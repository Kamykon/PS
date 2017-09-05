import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

/**
 * Created by Michal on 05.09.2017.
 */
public class UDP extends Thread {

    DatagramSocket server;
    boolean isFirstMsg = true;
    int recvBufferSize;
    long recvDataSize;
    long startTime;
    long currentTime;
    long statisticsTime = 0L;
    long transmissionTime;
    double transmissionSpeed;
    boolean done = false;
    double packetLoss;
    int dataLength;
    int lostBytes = 0;

    public void run()
    {
        try {
            server = new DatagramSocket(7777);
            byte[] messageByte = new byte[(int)65500.0D];
            byte[] firstMessageByte = new byte[(int)65500.0D];
            while (!done) {
                DatagramPacket pack = new DatagramPacket(messageByte, messageByte.length);
                server.receive(pack);
                dataLength = pack.getLength();
                if (isFirstMsg) {
                    String[] firstMsg = new String(pack.getData(), pack.getOffset(), pack.getLength()).split(":");
                    if (firstMsg[0].equalsIgnoreCase("SIZE"))
                    {
                        recvBufferSize = new Integer(firstMsg[1]).intValue();
                        firstMessageByte = getSenderBuffer(recvBufferSize);
                        isFirstMsg = false;
                        startTime = System.currentTimeMillis();
                        recvDataSize = 0L;
                    }
                } else {
                    statistic(firstMessageByte, messageByte, pack.getLength());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void statistic(byte[] pattern, byte[] current, int currentSize)
    {
        currentTime = System.currentTimeMillis();
        transmissionTime = (currentTime - startTime);
        recvDataSize += recvBufferSize;
        transmissionSpeed = (recvDataSize * 1000.0D / (transmissionTime - statisticsTime));
        long stopStat = System.currentTimeMillis();
        statisticsTime += stopStat - currentTime;
        packetLoss(recvBufferSize, dataLength);
    }

    public byte[] getSenderBuffer(int bufferSize) {
        byte[] buf = new byte[bufferSize];
        Arrays.fill(buf, (byte)7);
        return buf;
    }

    public void end()
    {
        done = true;
        server.close();
    }

    public void resetStatistics() {
        isFirstMsg = true;
        startTime = 0L;
        currentTime = 0L;
        statisticsTime = 0L;
        transmissionTime = 0L;
        recvBufferSize = 0;
        recvDataSize = 0L;
        transmissionSpeed = 0.0D;
        packetLoss = 0.0D;
        lostBytes = 0;
    }

    public void packetLoss(int expected, int given) {
        lostBytes += expected - given;
        packetLoss = 100 - (recvDataSize - lostBytes) * 100 / (double)recvDataSize;
    }
}

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Michal on 05.09.2017.
 */
public class UDP extends Thread {

    DatagramSocket server;
    boolean firstMessage = true;
    int bufferSize;
    long receivedData;
    long startTime;
    long currentTime;
    long transmissionTime;
    double transmissionSpeed;
    boolean done = false;
    double packetLoss;
    int dataLength;
    int lostBytes = 0;
    int port = 7777;

    UDP(int port) {
        this.port = port;
    }

    public void run()
    {
        try {
            server = new DatagramSocket(port);
            byte[] messageByte = new byte[(int)65500.0D];
            while (!done) {
                DatagramPacket pack = new DatagramPacket(messageByte, messageByte.length);
                server.receive(pack);
                dataLength = pack.getLength();
                if (firstMessage) {
                    String[] firstMsg = new String(pack.getData(), pack.getOffset(), pack.getLength()).split(":");
                    if (firstMsg[0].equalsIgnoreCase("SIZE"))
                    {
                        bufferSize = new Integer(firstMsg[1]).intValue();
                        firstMessage = false;
                        startTime = System.currentTimeMillis();
                        receivedData = 0L;
                    }
                } else {
                    stats();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stats()
    {
        currentTime = System.currentTimeMillis();
        transmissionTime = (currentTime - startTime);
        receivedData += bufferSize;
        transmissionSpeed = (receivedData * 1000.0D / (transmissionTime));
        packetLoss(bufferSize, dataLength);
    }

    public void end()
    {
        done = true;
        server.close();
    }

    public void resetStats() {
        firstMessage = true;
        startTime = 0;
        currentTime = 0;
        transmissionTime = 0;
        bufferSize = 0;
        receivedData = 0;
        transmissionSpeed = 0;
        packetLoss = 0;
        lostBytes = 0;
    }

    public void packetLoss(int expected, int given) {
        lostBytes += expected - given;
        packetLoss = 100 - (receivedData - lostBytes) * 100 / (double) receivedData;
    }
}

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by Michal on 04.09.2017.
 */
public class TCP extends Thread{
    ServerSocket server;
    Socket clientSocket;
    boolean isFirstMsg = true;
    int recvBufferSize;
    long recvDataSize;
    long startTime;
    long currentTime;
    long statisticsTime = 0L;
    long transmissionTime;
    double transmissionSpeed;
    boolean done = false;

    public void run() {
        try {
            server = new ServerSocket(7777, 0, null);
            while(!done) {
                clientSocket = server.accept();
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                byte[] messageByte = new byte[(int)65500.0D];
                byte[] firstMessageByte = new byte[(int)65500.0D];
                while(!done) {
                    int bytesRead = in.read(messageByte);
                    if (bytesRead < 0) {
                        break;
                    }
                    if (isFirstMsg) {
                        String[] firstMsg = new String(messageByte, 0, bytesRead).split(":");
                        if (firstMsg[0].equalsIgnoreCase("SIZE"))
                        {
                            recvBufferSize = new Integer(firstMsg[1]).intValue();
                            firstMessageByte = getSenderBuffer(recvBufferSize);
                            isFirstMsg = false;
                            startTime = System.currentTimeMillis();
                            recvDataSize = 0L;
                        }
                    } else {
                        statistic(firstMessageByte, messageByte, bytesRead);
                    }
                }
                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] getSenderBuffer(int bufferSize) {
        byte[] buf = new byte[bufferSize];
        Arrays.fill(buf, (byte)7);
        return buf;
    }

    public void statistic(byte[] pattern, byte[] current, int currentSize)
    {
        currentTime = System.currentTimeMillis();
        transmissionTime = (currentTime - startTime);
        recvDataSize += recvBufferSize;
        transmissionSpeed = (recvDataSize * 1000.0D / (transmissionTime - statisticsTime));
        long stopStat = System.currentTimeMillis();
        statisticsTime += stopStat - currentTime;
    }

    public void end() {
        done = true;
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    }
}

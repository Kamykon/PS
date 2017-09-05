import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Michal on 04.09.2017.
 */
public class TCP extends Thread{
    ServerSocket server;
    Socket clientSocket;
    boolean firstMessage = true;
    int bufferSize;
    long receivedData;
    long startTime;
    long currentTime;
    long statisticsTime = 0L;
    long transmissionTime;
    double transmissionSpeed;
    boolean done = false;
    int port = 7777;

    TCP(int port) {
        this.port = port;
    }

    public void run() {
        try {
            server = new ServerSocket(port, 0, null);
            while(!done) {
                clientSocket = server.accept();
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                byte[] messageByte = new byte[(int)65500.0D];
                while(!done) {
                    int bytesRead = in.read(messageByte);
                    if (bytesRead < 0) {
                        break;
                    }
                    if (firstMessage) {
                        String[] firstMsg = new String(messageByte, 0, bytesRead).split(":");
                        if (firstMsg[0].equalsIgnoreCase("SIZE"))
                        {
                            bufferSize = new Integer(firstMsg[1]).intValue();
                            firstMessage = false;
                            startTime = System.currentTimeMillis();
                            receivedData = 0L;
                        }
                    } else {
                        statistic();
                    }
                }
                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void statistic()
    {
        currentTime = System.currentTimeMillis();
        transmissionTime = (currentTime - startTime);
        receivedData += bufferSize;
        transmissionSpeed = (receivedData * 1000.0D / (transmissionTime - statisticsTime));
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
        firstMessage = true;
        startTime = 0;
        currentTime = 0;
        statisticsTime = 0;
        transmissionTime = 0;
        bufferSize = 0;
        receivedData = 0;
        transmissionSpeed = 0;
    }
}

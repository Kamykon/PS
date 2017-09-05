import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by Michal on 04.09.2017.
 */
public class TCP extends Thread{
    Socket clientSocket;
    boolean nagle = false;
    int bufferSize = 100;
    boolean done = false;
    String addressIP = "127.0.0.1";
    int port = 7777;

    TCP(boolean nagle, int bufferSize, String addressIP, int port) {
        this.nagle = nagle;
        this.bufferSize = bufferSize;
        this.addressIP = addressIP;
        this.port = port;
    }

    public void run() {
        try {
            clientSocket = new Socket(addressIP, port);
            clientSocket.setTcpNoDelay(nagle);
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            sleep(200);
            byte[] firstMessage = new String("SIZE:" + bufferSize).getBytes();
            out.write(firstMessage, 0, firstMessage.length);
            byte[] buffer = prepareBuffer();
            while(!done) {
                sleep(10);
                out.write(buffer, 0, buffer.length);
            }
        } catch (IOException e) {
            if(!done) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public byte[] prepareBuffer() {
        byte[] buffer = new byte[bufferSize];
        Arrays.fill(buffer, (byte)bufferSize);
        return buffer;
    }

    public void end()
    {
        try {
            done = true;
            clientSocket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

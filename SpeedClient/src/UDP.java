import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/**
 * Created by Michal on 05.09.2017.
 */
public class UDP extends Thread {
    DatagramSocket server;
    int bufferSize = 100;
    boolean done = false;
    String addressIP = "127.0.0.1";
    int port = 7777;

    UDP(int bufferSize, String addressIP, int port) {
        this.bufferSize = bufferSize;
        this.addressIP = addressIP;
        this.port = port;
    }

    public void run()
    {
        byte[] buffer = prepareBuffer();
        try {
            server = new DatagramSocket();
            sleep(200);
            byte[] firstMessage = new String("SIZE:" + bufferSize).getBytes();
            DatagramPacket packet = new DatagramPacket(firstMessage, firstMessage.length, InetAddress.getByName(addressIP), port);
            server.send(packet);
            packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(addressIP), port);
            while (!done) {
                sleep(10);
                server.send(packet);
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
        byte[] buf = new byte[bufferSize];
        Arrays.fill(buf, (byte)bufferSize);
        return buf;
    }

    public void end()
    {
        try {
            done = true;
            server.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

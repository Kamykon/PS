/**
 * Created by Michal on 04.09.2017.
 */
public class Sender {

    TCP tcp;
    UDP udp;
    boolean exist = false;
    boolean nagle = false;
    int bufferSize = 100;
    String addressIP = "127.0.0.1";
    int port = 7777;

    public void create() {
        tcp = new TCP(nagle, bufferSize, addressIP, port);
        udp = new UDP(bufferSize, addressIP, port);
        tcp.start();
        udp.start();
        exist = true;
    }

    public void end() {
        tcp.end();
        udp.end();
        exist = false;
    }

    public void nagle() {
        nagle = !nagle;
    }
}

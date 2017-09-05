import java.util.Scanner;

/**
 * Created by Michal on 05.09.2017.
 */
public class Menu {

    int port = 7777;

    public void start() {
        Scanner in = new Scanner(System.in);
        TCP tcp = new TCP(port);
        UDP udp = new UDP(port);
        int a;
        do {
            System.out.println("0 - Koniec");
            System.out.println("1 - Start");
            System.out.println("2 - Statystyki");
            System.out.println("3 - Reset statystyk");
            System.out.println("4 - Port (domyslnie 7777)");
            a = in.nextInt();
            switch (a) {
                case 0:
                    tcp.end();
                    udp.end();
                    break;
                case 1:
                    tcp.start();
                    udp.start();
                    break;
                case 2:
                    System.out.println("TCP:");
                    System.out.println("Single data size: " + tcp.bufferSize);
                    System.out.println("Recieved: " + tcp.receivedData);
                    System.out.println("Speed: " + tcp.transmissionSpeed);
                    System.out.println("Time: " + tcp.transmissionTime / 1000 + "s");
                    System.out.println("UDP:");
                    System.out.println("Single data size: " + udp.bufferSize);
                    System.out.println("Recieved: " + udp.receivedData);
                    System.out.println("Speed: " + udp.transmissionSpeed);
                    System.out.println("Time: " + udp.transmissionTime / 1000 + "s");
                    System.out.println("Packet loss: " + udp.packetLoss + "%");
                    System.out.println("Lost bytes: " + udp.lostBytes);
                    break;
                case 3:
                    tcp.resetStatistics();
                    udp.resetStats();
                    break;
                case 4:
                    port = in.nextInt();
                    break;

            }
        } while(a!=0);
    }

}

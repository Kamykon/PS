import java.util.Scanner;

/**
 * Created by Michal on 05.09.2017.
 */
public class Menu {

    TCP tcp;
    UDP udp;

    Menu(TCP tcp, UDP udp) {
        this.tcp = tcp;
        this.udp = udp;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        int a;
        do {
            System.out.println("1 - Koniec");
            System.out.println("2 - Statystyki");
            System.out.println("3 - Reset statystyk");
            a = in.nextInt();
            switch (a) {
                case 1:
                    tcp.end();
                    udp.end();
                    break;
                case 2:
                    System.out.println("TCP:");
                    System.out.println("Single data size: " + tcp.recvBufferSize);
                    System.out.println("Recieved: " + tcp.recvDataSize);
                    System.out.println("Speed: " + tcp.transmissionSpeed);
                    System.out.println("Time: " + tcp.transmissionTime / 1000 + "s");
                    System.out.println("UDP:");
                    System.out.println("Single data size: " + udp.recvBufferSize);
                    System.out.println("Recieved: " + udp.recvDataSize);
                    System.out.println("Speed: " + udp.transmissionSpeed);
                    System.out.println("Time: " + udp.transmissionTime / 1000 + "s");
                    System.out.println("Packet loss: " + udp.packetLoss + "%");
                    System.out.println("Lost bytes: " + udp.lostBytes);
                    break;
                case 3:
                    tcp.resetStatistics();
                    udp.resetStatistics();
            }
        } while(a!=1);
    }

}

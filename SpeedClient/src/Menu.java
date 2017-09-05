import java.net.SocketException;
import java.util.Scanner;

/**
 * Created by Michal on 05.09.2017.
 */
public class Menu {

    Sender sender;

    Menu(Sender sender) {
        this.sender = sender;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        int a;
        do {
            System.out.println("0 - Koniec");
            System.out.println("1 - Start");
            System.out.println("2 - Nagle");
            System.out.println("3 - Buffer (domyslnie 100, min 50 max 65500)");
            System.out.println("4 - IP (domyslnie localhost)");
            System.out.println("5 - Port (domyslnie 7777)");
            a = in.nextInt();
            switch (a) {
                case 0:
                    if(sender.exist) {
                        sender.end();
                    }
                    break;
                case 1:
                    if(!sender.exist) {
                        sender.create();
                    }
                    break;
                case 2:
                    if(!sender.exist) {
                        sender.nagle();
                    }
                    else {
                        System.out.print("nagle ");
                        try {
                            if(sender.tcp.clientSocket.getTcpNoDelay()) {
                                System.out.println("ON");
                            }
                            else {
                                System.out.println("OFF");
                            }
                        } catch (SocketException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    if(!sender.exist) {
                        sender.bufferSize = in.nextInt();
                        if (sender.bufferSize < 50) {
                            sender.bufferSize = 50;
                        }
                        if (sender.bufferSize > 65500) {
                            sender.bufferSize = 65500;
                        }
                    }
                    break;
                case 4:
                    if(!sender.exist) {
                        sender.addressIP = in.next();
                    }
                    break;
                case 5:
                    if(!sender.exist) {
                        sender.port = in.nextInt();
                    }
                    break;
            }
        } while(a!=0);
    }
}

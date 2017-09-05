import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Michal on 03.09.2017.
 */
public class Main {

    public static void main(String[] Args) {
        TCP tcp = new TCP();
        UDP udp = new UDP();
        Menu menu = new Menu(tcp, udp);

        tcp.start();
        udp.start();
        menu.start();
    }

}

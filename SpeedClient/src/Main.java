import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Michal on 03.09.2017.
 */
public class Main {

    public static void main(String[] Args) {
        Sender sender = new Sender();
        Menu menu = new Menu(sender);
        menu.start();
    }


}

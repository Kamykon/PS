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

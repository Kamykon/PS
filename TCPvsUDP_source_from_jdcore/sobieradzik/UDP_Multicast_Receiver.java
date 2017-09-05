package sobieradzik;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MulticastSocket;
import java.util.ArrayList;

public class UDP_Multicast_Receiver extends Thread
{
  static UDP_Multicast_Receiver me = null;
  int port;
  String group;
  MulticastSocket s;
  ArrayList<String> addresses = new ArrayList();
  public static ArrayList<String> userAddedAddresses = new ArrayList();
  boolean isReceiving = false;
  public static boolean addressesChanged = false;
  
  private UDP_Multicast_Receiver() {}
  
  public static void Start(String _group, int _port)
  {
    if (me == null)
      me = new UDP_Multicast_Receiver();
    me.init(_group, _port);
    refreshAddressList();
  }
  
  private void init(String _group, int _port) {
    clearAddressList();
    port = _port;
    group = _group;
    try {
      s = new MulticastSocket(port);
      s.setReuseAddress(true);
      s.setSoTimeout(1000);
      s.joinGroup(java.net.InetAddress.getByName(group));
      start();
    }
    catch (IOException e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
  }
  
  public static void Stop() {
    try {
      meisReceiving = false;
      mes.leaveGroup(java.net.InetAddress.getByName(megroup));
      mes.close();
    }
    catch (IOException e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
  }
  
  public void run() {
    byte[] buf = new byte['Ѐ'];
    java.net.DatagramPacket pack = new java.net.DatagramPacket(buf, buf.length);
    isReceiving = true;
    System.out.println("Start listening on " + group + ":" + port);
    while (isReceiving) {
      try
      {
        s.receive(pack);
        String[] msg = new String(pack.getData(), pack.getOffset(), pack.getLength()).split(":");
        System.out.println("    " + msg[0]);
        if (msg[0].startsWith("OFFER")) {
          String addr = pack.getAddress().toString();
          addr = addr.substring(addr.lastIndexOf("/") + 1) + ":" + msg[1];
          java.util.Set<String> set = new java.util.HashSet(addresses);
          if (set.contains(addr)) {
            System.out.println("Found again server " + addr);
            continue;
          }
          addresses.add(addr);
          addressesChanged = true;
          System.out.println("Added server to list: " + addr);
        }
      } catch (IOException e) {
        if (!e.getMessage().equalsIgnoreCase("Receive timed out"))
        {
          e.printStackTrace();
          System.out.println(e.getMessage());
        }
      }
    }
    System.out.println("Finish multicast listening");
  }
  
  public static ArrayList getAddressList() {
    return meaddresses;
  }
  
  public static void clearAddressList() {
    meaddresses.clear();
    for (int i = 0; i < userAddedAddresses.size(); i++)
      meaddresses.add(userAddedAddresses.get(i));
    addressesChanged = true;
  }
  
  public static void refreshAddressList() {
    clearAddressList();
    UDP_Multicast_Sender.sendData(megroup, meport, "DISCOVER");
  }
}

package sobieradzik;

import java.io.IOException;

public class UDP_Multicast_Receiver extends Thread { int port;
  public static int serverPort;
  String group;
  java.net.MulticastSocket s;
  
  public UDP_Multicast_Receiver() {}
  
  boolean isReceiving = false;
  
  public void Start(String _group, int _port) {
    port = _port;
    group = _group;
    try
    {
      s = new java.net.MulticastSocket(port);
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
  
  public void Stop()
  {
    try {
      isReceiving = false;
      s.leaveGroup(java.net.InetAddress.getByName(group));
      s.close();
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
        String msg = new String(pack.getData(), pack.getOffset(), pack.getLength());
        System.out.println("    " + msg);
        System.out.println("Received " + pack.getLength() + " from " + pack.getAddress().toString() + ":" + pack.getPort());
        if (msg.equalsIgnoreCase("DISCOVER")) {
          UDP_Multicast_Sender.sendData(group, port, "OFFER:" + serverPort);
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
}

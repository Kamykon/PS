package sobieradzik;

import java.net.MulticastSocket;

public class UDP_Multicast_Sender
{
  public UDP_Multicast_Sender() {}
  
  public static void sendData(String group, int port, String mesg) {
    int ttl = 1;
    try
    {
      MulticastSocket s = new MulticastSocket();
      


      byte[] buf = mesg.getBytes(java.nio.charset.Charset.forName("UTF-8"));
      
      java.net.DatagramPacket pack = new java.net.DatagramPacket(buf, buf.length, java.net.InetAddress.getByName(group), port);
      
      s.send(pack, (byte)ttl);
      
      s.close();
    }
    catch (java.io.IOException e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
  }
}

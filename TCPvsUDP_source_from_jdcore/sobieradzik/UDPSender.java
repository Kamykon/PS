package sobieradzik;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;









public class UDPSender
  extends CommonSender
{
  DatagramSocket server;
  
  public UDPSender(String _ipAddress, int _port, boolean _nagle, int _bufferSize)
  {
    ipAddress = _ipAddress;
    port = _port;
    nagle = _nagle;
    bufferSize = _bufferSize;
  }
  
  public void terminate()
  {
    try {
      isTerminated = true;
      server.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void run()
  {
    byte[] buf = getSenderBuffer();
    try {
      server = new DatagramSocket();
      hasConnection = true;
      sleep(200L);
      byte[] firstMsg = new String("SIZE:" + bufferSize).getBytes();
      DatagramPacket pack = new DatagramPacket(firstMsg, firstMsg.length, InetAddress.getByName(ipAddress), port);
      server.send(pack);
      pack = new DatagramPacket(buf, buf.length, InetAddress.getByName(ipAddress), port);
      while (!isTerminated) {
        sleep(10L);
        server.send(pack);
      }
    } catch (IOException e) {
      hasConnection = false;
      e.printStackTrace();
    } catch (InterruptedException ex) {
      Logger.getLogger(UDPSender.class.getName()).log(Level.SEVERE, null, ex);
    }
    hasConnection = false;
  }
}

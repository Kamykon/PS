package sobieradzik;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;








public class TCPSender
  extends CommonSender
{
  Socket clientSocket;
  
  public TCPSender(String _ipAddress, int _port, boolean _nagle, int _bufferSize)
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
      clientSocket.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void run()
  {
    try {
      clientSocket = new Socket(ipAddress, port);
      clientSocket.setTcpNoDelay(!nagle);
      hasConnection = true;
      DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
      sleep(200L);
      byte[] firstMsg = new String("SIZE:" + bufferSize).getBytes();
      outToServer.write(firstMsg, 0, firstMsg.length);
      byte[] buf = getSenderBuffer();
      while (!isTerminated) {
        sleep(10L);
        outToServer.write(buf, 0, buf.length);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException ex) {
      Logger.getLogger(TCPSender.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    hasConnection = false;
  }
}

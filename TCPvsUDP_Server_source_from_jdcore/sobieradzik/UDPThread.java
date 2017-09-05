package sobieradzik;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;








public class UDPThread
  extends CommonThread
{
  DatagramSocket server;
  
  public UDPThread(int _port)
  {
    port = _port;
  }
  
  public void terminate()
  {
    isTerminated = true;
    server.close();
  }
  
  public void run()
  {
    try {
      server = new DatagramSocket(port);
      isListening = true;
      byte[] messageByte = new byte[(int)CommonThread.dataLength];
      byte[] firstMessageByte = new byte[(int)CommonThread.dataLength];
      while (!isTerminated) {
        DatagramPacket pack = new DatagramPacket(messageByte, messageByte.length);
        server.receive(pack);
        if (isFirstMsg) {
          String[] firstMsg = new String(pack.getData(), pack.getOffset(), pack.getLength()).split(":");
          if (firstMsg[0].equalsIgnoreCase("SIZE"))
          {
            recvBufferSize = new Integer(firstMsg[1]).intValue();
            firstMessageByte = getSenderBuffer(recvBufferSize);
            isFirstMsg = false;
            startTime = System.currentTimeMillis();
            recvDataSize = 0L;
          }
        } else {
          statistic(firstMessageByte, messageByte, pack.getLength());
        }
      }
    } catch (IOException e) { isListening = false;
      e.printStackTrace();
    }
    Logger.getLogger(UDPThread.class.getName()).log(Level.INFO, "UDP listening terminated", Integer.valueOf(11));
    isListening = false;
  }
}

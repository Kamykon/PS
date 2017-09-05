package sobieradzik;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;







public class TCPThread
  extends CommonThread
{
  ServerSocket server;
  Socket clientSocket;
  
  public TCPThread(int _port)
  {
    port = _port;
  }
  
  public void terminate()
  {
    isTerminated = true;
    try {
      server.close();
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
      e.printStackTrace();
    }
  }
  
  public void run()
  {
    try {
      server = new ServerSocket(port, 0, null);
      isListening = true;
      while (!isTerminated) {
        Logger.getLogger(TCPThread.class.getName()).log(Level.INFO, "Starting TCP listening", Integer.valueOf(11));
        clientSocket = server.accept();
        resetStatistics();
        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        byte[] messageByte = new byte[(int)CommonThread.dataLength];
        byte[] firstMessageByte = new byte[(int)CommonThread.dataLength];
        while (!isTerminated) {
          int bytesRead = in.read(messageByte);
          if (bytesRead < 0) {
            break;
          }
          if (isFirstMsg) {
            String[] firstMsg = new String(messageByte, 0, bytesRead).split(":");
            if (firstMsg[0].equalsIgnoreCase("SIZE"))
            {
              recvBufferSize = new Integer(firstMsg[1]).intValue();
              firstMessageByte = getSenderBuffer(recvBufferSize);
              isFirstMsg = false;
              startTime = System.currentTimeMillis();
              recvDataSize = 0L;
            }
          } else {
            statistic(firstMessageByte, messageByte, bytesRead);
          } }
        clientSocket.close();
      }
    } catch (IOException e) {
      isListening = false;
      
      e.printStackTrace();
    }
    Logger.getLogger(TCPThread.class.getName()).log(Level.INFO, "TCP listening terminated", Integer.valueOf(11));
    isListening = false;
  }
}

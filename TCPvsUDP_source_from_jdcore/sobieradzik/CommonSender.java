package sobieradzik;

import java.util.Arrays;






public abstract class CommonSender
  extends Thread
{
  String ipAddress;
  int port;
  boolean nagle;
  int bufferSize;
  
  public CommonSender() {}
  
  boolean hasConnection = false;
  boolean isTerminated = false;
  
  public boolean isConnected() {
    return hasConnection;
  }
  
  public byte[] getSenderBuffer() {
    byte[] buf = new byte[bufferSize];
    Arrays.fill(buf, (byte)7);
    return buf;
  }
  
  public abstract void terminate();
}

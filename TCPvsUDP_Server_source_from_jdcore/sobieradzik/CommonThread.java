package sobieradzik;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;



public abstract class CommonThread
  extends Thread
{
  public static ArrayList<InetAddress> thisServerAddresses = new ArrayList();
  static double dataLength = 65500.0D;
  int port;
  boolean isListening = false;
  boolean isTerminated = false;
  boolean isFirstMsg = true;
  long startTime;
  long currentTime;
  long statisticsTime = 0L;
  long transmissionTime;
  int recvBufferSize;
  long recvDataSize;
  int recvBuffersLost = 0;
  double transmissionSpeed;
  double transmissionError;
  
  public CommonThread() {
    isListening = false;
    isTerminated = false;
    resetStatistics();
  }
  
  public byte[] getSenderBuffer(int bufferSize) {
    byte[] buf = new byte[bufferSize];
    Arrays.fill(buf, (byte)7);
    return buf;
  }
  
  public boolean isListening() {
    return isListening;
  }
  
  public long getRecvSingleDataSize() { return recvBufferSize; }
  
  public double getRecvDataSize() {
    return recvDataSize / 1024.0D;
  }
  
  public int getRecvBuffersLost() { return recvBuffersLost; }
  
  public double getTransmissionTime() {
    return (transmissionTime - statisticsTime) / 1000.0D;
  }
  
  public double getStatisticsTime() { return statisticsTime; }
  
  public double getTransmissionSpeed() {
    return transmissionSpeed;
  }
  
  public double getTransmissionError() { return transmissionError; }
  
  protected void statistic(byte[] pattern, byte[] current, int currentSize)
  {
    currentTime = System.currentTimeMillis();
    transmissionTime = (currentTime - startTime);
    recvDataSize += recvBufferSize;
    transmissionSpeed = (recvDataSize * 1000.0D / (transmissionTime - statisticsTime));
    



    long stopStat = System.currentTimeMillis();
    statisticsTime += stopStat - currentTime;
    Logger.getLogger(CommonThread.class.getName()).log(Level.INFO, getClass().getName() + ": recvDataSize=" + recvDataSize + "; transmissionSpeed=" + transmissionSpeed + "; statisticsTime=" + statisticsTime, Integer.valueOf(11));
  }
  
  protected void resetStatistics() {
    isFirstMsg = true;
    startTime = 0L;
    currentTime = 0L;
    statisticsTime = 0L;
    transmissionTime = 0L;
    recvBufferSize = 0;
    recvDataSize = 0L;
    recvBuffersLost = 0;
    transmissionSpeed = 0.0D;
    transmissionError = 0.0D;
    if (((this instanceof TCPThread)) && (TCPvsUDPListener.me != null))
      meudpThread.resetStatistics();
  }
  
  public abstract void terminate();
  
  static void displayInterfaceInformation() {
    try {
      Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
      for (NetworkInterface netint : Collections.list(nets)) {
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        if ((netint.isUp()) && (!netint.isLoopback()) && (!netint.isVirtual())) {
          for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            if ((inetAddress instanceof Inet4Address))
            {
              thisServerAddresses.add(inetAddress);
            }
          }
        }
      }
    } catch (SocketException e) {
      e.printStackTrace();
    }
    for (InetAddress addr : thisServerAddresses) {
      Logger.getLogger(CommonThread.class.getName()).log(Level.INFO, "Found network interface: " + addr, Integer.valueOf(11));
    }
  }
}

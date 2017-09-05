package sobieradzik;
















public class TCPvsUDPListener
{
  static TCPvsUDPListener me = null;
  int port;
  TCPThread tcpThread;
  UDPThread udpThread;
  public static boolean isStarted = false;
  UDP_Multicast_Receiver finder = new UDP_Multicast_Receiver();
  
  private TCPvsUDPListener(int _port) {
    port = _port;
    UDP_Multicast_Receiver.serverPort = port;
    finder.Start("224.0.0.10", 65000);
    tcpThread = new TCPThread(port);
    udpThread = new UDPThread(port);
    tcpThread.start();
    udpThread.start();
    isStarted = true;
  }
  
  public static void startListening(int _port) {
    if (me != null) {
      metcpThread.terminate();
      meudpThread.terminate();
      me = null;
    }
    me = new TCPvsUDPListener(_port);
  }
  
  public static void stopListening() {
    if (me != null) {
      metcpThread.terminate();
      meudpThread.terminate();
      mefinder.Stop();
      me = null;
      isStarted = false;
    }
  }
  
  public static CommonThread getThread(String proto) {
    if (proto.equalsIgnoreCase("TCP"))
      return metcpThread;
    if (proto.equalsIgnoreCase("UDP")) {
      return meudpThread;
    }
    return null;
  }
}

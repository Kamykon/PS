package sobieradzik;




public class TCPvsUDPSender
{
  static TCPvsUDPSender me;
  

  TCPSender tcpSender;
  

  UDPSender udpSender;
  

  static boolean isStarted = false;
  
  TCPvsUDPSender(String _ipAddress, boolean _nagle, int _bufferSize) {
    String[] addr = _ipAddress.split(":");
    String ipAddress = addr[0];
    int port = new Integer(addr[1]).intValue();
    tcpSender = new TCPSender(ipAddress, port, _nagle, _bufferSize);
    tcpSender.start();
    udpSender = new UDPSender(ipAddress, port, _nagle, _bufferSize);
    udpSender.start();
    isStarted = true;
  }
  
  public static void startSenders(String _ipAddress, boolean _nagle, int _bufferSize) {
    me = new TCPvsUDPSender(_ipAddress, _nagle, _bufferSize);
  }
  
  public static void stopSenders() {
    metcpSender.terminate();
    meudpSender.terminate();
    me = null;
    isStarted = false;
  }
  
  public static CommonSender getSender(String proto) {
    if (proto.equalsIgnoreCase("TCP"))
      return metcpSender;
    if (proto.equalsIgnoreCase("UDP")) {
      return meudpSender;
    }
    return null;
  }
}

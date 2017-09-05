package sobieradzik;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class MainJDialog extends javax.swing.JDialog
{
  ArrayList<JCheckBox> netsCheckBoxes = new ArrayList();
  JCheckBox[] checkBoxList;
  private JButton jButton_StartStop;
  private JFormattedTextField jFormattedTextField_Port;
  
  public MainJDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    CommonThread.displayInterfaceInformation();
    








    new GUIThread(this).start();
  }
  
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JLabel jLabel6;
  private JLabel jLabel7;
  
  private void initComponents() {
    jLabel1 = new JLabel();
    jButton_StartStop = new JButton();
    jFormattedTextField_Port = new JFormattedTextField();
    jPanel1 = new JPanel();
    jLabel2 = new JLabel();
    jLabel_TCP = new JLabel();
    jLabel_UDP = new JLabel();
    jSeparator1 = new JSeparator();
    jSeparator2 = new JSeparator();
    jLabel3 = new JLabel();
    jLabel4 = new JLabel();
    jLabel5 = new JLabel();
    jLabel6 = new JLabel();
    jLabel7 = new JLabel();
    jLabel8 = new JLabel();
    jTextField_TCP_SingleDataSize = new JTextField();
    jTextField_TCP_TotalTransferSize = new JTextField();
    jTextField_TCP_TotalTransmissionTime = new JTextField();
    jTextField_TCP_TotalStatsTime = new JTextField();
    jTextField_TCP_TransmissionSpeed = new JTextField();
    jTextField_TCP_LostData = new JTextField();
    jTextField_TCP_TransmissionError = new JTextField();
    jTextField_UDP_SingleDataSize = new JTextField();
    jTextField_UDP_TotalTransferSize = new JTextField();
    jTextField_UDP_TotalTransmissionTime = new JTextField();
    jTextField_UDP_TotalStatsTime = new JTextField();
    jTextField_UDP_TransmissionSpeed = new JTextField();
    jTextField_UDP_LostData = new JTextField();
    jTextField_UDP_TransmissionError = new JTextField();
    
    setDefaultCloseOperation(2);
    
    jLabel1.setText("Listening port:");
    
    jButton_StartStop.setText("Start listening");
    jButton_StartStop.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJDialog.this.jButton_StartStopActionPerformed(evt);
      }
      
    });
    jFormattedTextField_Port.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
    jFormattedTextField_Port.setHorizontalAlignment(4);
    jFormattedTextField_Port.setText("7777");
    
    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Transmissions statisctics"));
    
    jLabel2.setText("Single data size [bytes]");
    
    jLabel_TCP.setFont(new java.awt.Font("Tahoma", 1, 18));
    jLabel_TCP.setForeground(new Color(255, 0, 51));
    jLabel_TCP.setText("TCP");
    
    jLabel_UDP.setFont(new java.awt.Font("Tahoma", 1, 18));
    jLabel_UDP.setForeground(new Color(255, 0, 51));
    jLabel_UDP.setText("UDP");
    
    jSeparator1.setOrientation(1);
    
    jSeparator2.setOrientation(1);
    
    jLabel3.setText("Total size of tranfered data [kbytes]");
    
    jLabel4.setText("Total transmission time [sec]");
    
    jLabel5.setText("Statistics calculation time [msec]");
    
    jLabel6.setText("Transmision speed [kbytes/sec]");
    
    jLabel7.setText("Lost data [bytes]");
    
    jLabel8.setText("Transmission error [%]");
    
    jTextField_TCP_SingleDataSize.setEditable(false);
    jTextField_TCP_SingleDataSize.setHorizontalAlignment(4);
    jTextField_TCP_SingleDataSize.setText("0");
    
    jTextField_TCP_TotalTransferSize.setEditable(false);
    jTextField_TCP_TotalTransferSize.setHorizontalAlignment(4);
    jTextField_TCP_TotalTransferSize.setText("0");
    
    jTextField_TCP_TotalTransmissionTime.setEditable(false);
    jTextField_TCP_TotalTransmissionTime.setHorizontalAlignment(4);
    jTextField_TCP_TotalTransmissionTime.setText("0");
    
    jTextField_TCP_TotalStatsTime.setEditable(false);
    jTextField_TCP_TotalStatsTime.setHorizontalAlignment(4);
    jTextField_TCP_TotalStatsTime.setText("0");
    
    jTextField_TCP_TransmissionSpeed.setEditable(false);
    jTextField_TCP_TransmissionSpeed.setHorizontalAlignment(4);
    jTextField_TCP_TransmissionSpeed.setText("0");
    
    jTextField_TCP_LostData.setEditable(false);
    jTextField_TCP_LostData.setHorizontalAlignment(4);
    jTextField_TCP_LostData.setText("0");
    
    jTextField_TCP_TransmissionError.setEditable(false);
    jTextField_TCP_TransmissionError.setHorizontalAlignment(4);
    jTextField_TCP_TransmissionError.setText("0");
    
    jTextField_UDP_SingleDataSize.setEditable(false);
    jTextField_UDP_SingleDataSize.setHorizontalAlignment(4);
    jTextField_UDP_SingleDataSize.setText("0");
    
    jTextField_UDP_TotalTransferSize.setEditable(false);
    jTextField_UDP_TotalTransferSize.setHorizontalAlignment(4);
    jTextField_UDP_TotalTransferSize.setText("0");
    
    jTextField_UDP_TotalTransmissionTime.setEditable(false);
    jTextField_UDP_TotalTransmissionTime.setHorizontalAlignment(4);
    jTextField_UDP_TotalTransmissionTime.setText("0");
    
    jTextField_UDP_TotalStatsTime.setEditable(false);
    jTextField_UDP_TotalStatsTime.setHorizontalAlignment(4);
    jTextField_UDP_TotalStatsTime.setText("0");
    
    jTextField_UDP_TransmissionSpeed.setEditable(false);
    jTextField_UDP_TransmissionSpeed.setHorizontalAlignment(4);
    jTextField_UDP_TransmissionSpeed.setText("0");
    
    jTextField_UDP_LostData.setEditable(false);
    jTextField_UDP_LostData.setHorizontalAlignment(4);
    jTextField_UDP_LostData.setText("0");
    
    jTextField_UDP_TransmissionError.setEditable(false);
    jTextField_UDP_TransmissionError.setHorizontalAlignment(4);
    jTextField_UDP_TransmissionError.setText("0");
    
    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addContainerGap()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(jLabel2)
      .addComponent(jLabel3)
      .addComponent(jLabel4)
      .addComponent(jLabel5)
      .addComponent(jLabel6)
      .addComponent(jLabel7)
      .addComponent(jLabel8))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jSeparator1, -2, 11, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addComponent(jTextField_TCP_TransmissionError)
      .addComponent(jTextField_TCP_LostData)
      .addComponent(jTextField_TCP_TransmissionSpeed, -2, 108, -2)
      .addComponent(jTextField_TCP_TotalStatsTime)
      .addComponent(jTextField_TCP_TotalTransmissionTime)
      .addComponent(jTextField_TCP_TotalTransferSize)
      .addComponent(jTextField_TCP_SingleDataSize)
      .addComponent(jLabel_TCP))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, 32767)
      .addComponent(jSeparator2, -2, 11, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addComponent(jTextField_UDP_TransmissionError, -2, 108, -2)
      .addComponent(jTextField_UDP_LostData, -2, 108, -2)
      .addComponent(jTextField_UDP_TransmissionSpeed, -2, 108, -2)
      .addComponent(jTextField_UDP_TotalStatsTime, -2, 108, -2)
      .addComponent(jTextField_UDP_TotalTransmissionTime, -2, 108, -2)
      .addComponent(jTextField_UDP_TotalTransferSize, -2, 108, -2)
      .addComponent(jTextField_UDP_SingleDataSize, -2, 108, -2)
      .addComponent(jLabel_UDP))
      .addContainerGap()));
    
    jPanel1Layout.setVerticalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING)
      .addComponent(jSeparator2, GroupLayout.Alignment.TRAILING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addContainerGap()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(jLabel_UDP)
      .addComponent(jLabel_TCP))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addComponent(jLabel2)
      .addComponent(jTextField_TCP_SingleDataSize, -2, -1, -2)
      .addComponent(jTextField_UDP_SingleDataSize, -2, -1, -2))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addComponent(jTextField_UDP_TotalTransferSize, -2, -1, -2)
      .addComponent(jTextField_TCP_TotalTransferSize, -2, -1, -2)
      .addComponent(jLabel3, -2, 14, -2))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addComponent(jTextField_UDP_TotalTransmissionTime, -2, -1, -2)
      .addComponent(jTextField_TCP_TotalTransmissionTime, -2, -1, -2)
      .addComponent(jLabel4))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addComponent(jTextField_UDP_TotalStatsTime, -2, -1, -2)
      .addComponent(jTextField_TCP_TotalStatsTime, -2, -1, -2)
      .addComponent(jLabel5))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addComponent(jTextField_UDP_TransmissionSpeed, -2, -1, -2)
      .addComponent(jTextField_TCP_TransmissionSpeed, -2, -1, -2)
      .addComponent(jLabel6))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addComponent(jTextField_UDP_LostData, -2, -1, -2)
      .addComponent(jTextField_TCP_LostData, -2, -1, -2)
      .addComponent(jLabel7))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
      .addComponent(jTextField_UDP_TransmissionError, -2, -1, -2)
      .addComponent(jTextField_TCP_TransmissionError, -2, -1, -2)
      .addComponent(jLabel8))
      .addContainerGap(27, 32767)));
    

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, -1, -1, 32767)
      .addGroup(layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(jLabel1)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jFormattedTextField_Port, -2, 48, -2)
      .addGap(18, 18, 18)
      .addComponent(jButton_StartStop, -1, -1, 32767)))
      .addContainerGap()));
    
    layout.setVerticalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addContainerGap(-1, 32767)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(jLabel1)
      .addComponent(jButton_StartStop)
      .addComponent(jFormattedTextField_Port, -2, -1, -2))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jPanel1, -2, -1, -2)));
    

    pack(); }
  
  private JLabel jLabel8;
  private JLabel jLabel_TCP;
  
  private void jButton_StartStopActionPerformed(ActionEvent evt) { if (jButton_StartStop.getText().equalsIgnoreCase("Start listening")) {
      int port = Integer.valueOf(jFormattedTextField_Port.getText()).intValue();
      if ((port == 0) || (port > 65535) || (port < -65535)) { port = 7777;
      } else if (port < 0) port = -1 * port;
      jFormattedTextField_Port.setText("" + port);
      TCPvsUDPListener.startListening(port);
      jButton_StartStop.setText("Stop listening");
      jFormattedTextField_Port.setEnabled(false);
    }
    else if (jButton_StartStop.getText().equalsIgnoreCase("Stop listening")) {
      TCPvsUDPListener.stopListening();
      jButton_StartStop.setText("Start listening");
      jFormattedTextField_Port.setEnabled(true);
    } }
  
  private JLabel jLabel_UDP;
  private JPanel jPanel1;
  private JSeparator jSeparator1;
  private JSeparator jSeparator2;
  private JTextField jTextField_TCP_LostData;
  private JTextField jTextField_TCP_SingleDataSize;
  private JTextField jTextField_TCP_TotalStatsTime;
  private JTextField jTextField_TCP_TotalTransferSize;
  private JTextField jTextField_TCP_TotalTransmissionTime;
  private JTextField jTextField_TCP_TransmissionError;
  
  public static void main(String[] args) { try { for (UIManager.LookAndFeelInfo info : ) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(MainJDialog.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(MainJDialog.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(MainJDialog.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(MainJDialog.class.getName()).log(Level.SEVERE, null, ex);
    }
    


    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        Logger.getLogger(MainJDialog.class.getName()).log(Level.INFO, "Starting the program by Sobieradzik", Integer.valueOf(11));
        MainJDialog dialog = new MainJDialog(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter()
        {
          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      } }); }
  
  private JTextField jTextField_TCP_TransmissionSpeed;
  private JTextField jTextField_UDP_LostData;
  
  public void UpdateGUI() { if (!TCPvsUDPListener.isStarted) {
      jLabel_TCP.setForeground(Color.red);
      jLabel_UDP.setForeground(Color.red);
      return;
    }
    if (getThread"TCP"isListening)
      jLabel_TCP.setForeground(Color.green);
    if (getThread"UDP"isListening) {
      jLabel_UDP.setForeground(Color.green);
    }
    jTextField_TCP_SingleDataSize.setText("" + TCPvsUDPListener.getThread("TCP").getRecvSingleDataSize());
    jTextField_TCP_TotalTransferSize.setText(String.format("%.3f", new Object[] { Double.valueOf(TCPvsUDPListener.getThread("TCP").getRecvDataSize()) }));
    jTextField_TCP_TotalTransmissionTime.setText(String.format("%.1f", new Object[] { Double.valueOf(TCPvsUDPListener.getThread("TCP").getTransmissionTime()) }));
    jTextField_TCP_TotalStatsTime.setText(String.format("%.0f", new Object[] { Double.valueOf(TCPvsUDPListener.getThread("TCP").getStatisticsTime()) }));
    double speed = TCPvsUDPListener.getThread("TCP").getTransmissionSpeed();
    double factor = 1.0D;
    if (speed < 1024.0D) {
      factor = 1.0D;
      jLabel6.setText("Transmision speed [bytes/sec]");
    }
    else if (speed < 1048576.0D) {
      factor = 1024.0D;
      jLabel6.setText("Transmision speed [kbytes/sec]");
    }
    else if (speed < 1.073741824E9D) {
      factor = 1048576.0D;
      jLabel6.setText("Transmision speed [Mbytes/sec]");
    }
    jTextField_TCP_TransmissionSpeed.setText(String.format("%.3f", new Object[] { Double.valueOf(speed / factor) }));
    jTextField_TCP_LostData.setText("" + TCPvsUDPListener.getThread("TCP").getRecvBuffersLost());
    jTextField_TCP_TransmissionError.setText(String.format("%.1f", new Object[] { Double.valueOf(TCPvsUDPListener.getThread("TCP").getTransmissionError()) }));
    
    jTextField_UDP_SingleDataSize.setText("" + TCPvsUDPListener.getThread("UDP").getRecvSingleDataSize());
    jTextField_UDP_TotalTransferSize.setText(String.format("%.3f", new Object[] { Double.valueOf(TCPvsUDPListener.getThread("UDP").getRecvDataSize()) }));
    jTextField_UDP_TotalTransmissionTime.setText(String.format("%.1f", new Object[] { Double.valueOf(TCPvsUDPListener.getThread("UDP").getTransmissionTime()) }));
    jTextField_UDP_TotalStatsTime.setText(String.format("%.0f", new Object[] { Double.valueOf(TCPvsUDPListener.getThread("UDP").getStatisticsTime()) }));
    speed = TCPvsUDPListener.getThread("UDP").getTransmissionSpeed();
    jTextField_UDP_TransmissionSpeed.setText(String.format("%.3f", new Object[] { Double.valueOf(speed / factor) }));
    jTextField_UDP_LostData.setText("" + TCPvsUDPListener.getThread("UDP").getRecvBuffersLost());
    jTextField_UDP_TransmissionError.setText(String.format("%.1f", new Object[] { Double.valueOf(TCPvsUDPListener.getThread("UDP").getTransmissionError()) }));
  }
  
  private JTextField jTextField_UDP_SingleDataSize;
  private JTextField jTextField_UDP_TotalStatsTime;
  private JTextField jTextField_UDP_TotalTransferSize;
  private JTextField jTextField_UDP_TotalTransmissionTime;
  private JTextField jTextField_UDP_TransmissionError;
  private JTextField jTextField_UDP_TransmissionSpeed;
}

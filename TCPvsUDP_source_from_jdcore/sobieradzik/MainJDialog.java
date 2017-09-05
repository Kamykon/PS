package sobieradzik;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.ChangeEvent;

public class MainJDialog extends javax.swing.JDialog
{
  int currentListBoxItem = 0;
  private JButton jButton1;
  private JButton jButton_Refresh;
  
  public MainJDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    
    initComponents();
    try
    {
      javax.swing.ImageIcon image = new javax.swing.ImageIcon(javax.imageio.ImageIO.read(new java.net.URL("http://rwajman.iis.p.lodz.pl/public/icons4ps/refresh.png")));
      jButton_Refresh.setIcon(image);
      jButton_Refresh.setHorizontalTextPosition(0);
      jButton_Refresh.setVerticalTextPosition(3);
    }
    catch (java.net.MalformedURLException mue)
    {
      mue.printStackTrace();
    }
    catch (java.io.IOException ioe)
    {
      ioe.printStackTrace();
    }
    UDP_Multicast_Receiver.Start("224.0.0.10", 65000);
    jSpinner_Port.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner_Port, "#"));
    new GUIThread(this).start();
  }
  
  private JButton jButton_StartStop;
  private JCheckBox jCheckBox_Nagle;
  private JComboBox<String> jComboBox_Addresses;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel4Slider;
  
  private void initComponents() { jPanel1 = new JPanel();
    jComboBox_Addresses = new JComboBox();
    jLabel1 = new JLabel();
    jLabel2 = new JLabel();
    jSpinner_Port = new JSpinner();
    jCheckBox_Nagle = new JCheckBox();
    jButton_StartStop = new JButton();
    jLabel3 = new JLabel();
    jSlider_BufferSize = new JSlider();
    jLabel4Slider = new JLabel();
    jLabel4 = new JLabel();
    jTextField_addr = new JTextField();
    jButton1 = new JButton();
    jButton_Refresh = new JButton();
    jPanel2 = new JPanel();
    jLabel_TCPThread = new JLabel();
    jLabel_UDPThread = new JLabel();
    
    setDefaultCloseOperation(2);
    
    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Connection details"));
    jPanel1.setName("");
    
    jLabel1.setText("Server IP address");
    
    jLabel2.setText("Listening port");
    
    jSpinner_Port.setValue(Integer.valueOf(7777));
    
    jCheckBox_Nagle.setText("Nagle algorithm");
    jCheckBox_Nagle.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJDialog.this.jCheckBox_NagleActionPerformed(evt);
      }
      
    });
    jButton_StartStop.setText("Start transmission");
    jButton_StartStop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJDialog.this.jButton_StartStopActionPerformed(evt);
      }
      
    });
    jLabel3.setText("Sending buffer size");
    
    jSlider_BufferSize.setMaximum(65000);
    jSlider_BufferSize.setMinimum(1);
    jSlider_BufferSize.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(ChangeEvent evt) {
        MainJDialog.this.jSlider_BufferSizeStateChanged(evt);
      }
    });
    jSlider_BufferSize.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(PropertyChangeEvent evt) {
        MainJDialog.this.jSlider_BufferSizePropertyChange(evt);
      }
      
    });
    jLabel4Slider.setText("0 bytes");
    
    jLabel4.setText("New address");
    
    jTextField_addr.setText("127.0.0.1");
    
    jButton1.setText("Add address to the list below");
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJDialog.this.jButton1ActionPerformed(evt);
      }
      
    });
    jButton_Refresh.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainJDialog.this.jButton_RefreshActionPerformed(evt);
      }
      
    });
    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addContainerGap()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(jSlider_BufferSize, -1, -1, 32767)
      .addComponent(jButton_StartStop, -1, -1, 32767)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addComponent(jLabel3)
      .addGap(102, 102, 102)
      .addComponent(jCheckBox_Nagle)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
      .addComponent(jLabel4Slider))
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addComponent(jLabel1)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jComboBox_Addresses, -2, 213, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jButton_Refresh))
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(jLabel4)
      .addComponent(jTextField_addr, -2, 139, -2))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(jLabel2)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addComponent(jSpinner_Port, -2, 66, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jButton1)))))
      .addGap(0, 72, 32767)))
      .addContainerGap()));
    
    jPanel1Layout.setVerticalGroup(jPanel1Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addContainerGap(-1, 32767)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(jLabel2)
      .addComponent(jLabel4))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(jSpinner_Port, -2, -1, -2)
      .addComponent(jTextField_addr, -2, -1, -2)
      .addComponent(jButton1))
      .addGap(19, 19, 19)
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(jComboBox_Addresses, -2, -1, -2)
      .addComponent(jLabel1))
      .addGap(24, 24, 24))
      .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
      .addComponent(jButton_Refresh, -2, 34, -2)
      .addGap(18, 18, 18)))
      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(jLabel3)
      .addComponent(jLabel4Slider)
      .addComponent(jCheckBox_Nagle))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jSlider_BufferSize, -2, -1, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jButton_StartStop)
      .addGap(27, 27, 27)));
    

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));
    
    jLabel_TCPThread.setFont(new java.awt.Font("Tahoma", 1, 14));
    jLabel_TCPThread.setForeground(new Color(255, 0, 51));
    jLabel_TCPThread.setText("TCP thread: disconnected");
    
    jLabel_UDPThread.setFont(new java.awt.Font("Tahoma", 1, 14));
    jLabel_UDPThread.setForeground(new Color(255, 0, 51));
    jLabel_UDPThread.setText("UDP thread: stopped");
    
    GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
      .addContainerGap()
      .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(jLabel_TCPThread)
      .addComponent(jLabel_UDPThread))
      .addContainerGap(-1, 32767)));
    
    jPanel2Layout.setVerticalGroup(jPanel2Layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(jLabel_TCPThread)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jLabel_UDPThread)
      .addContainerGap(-1, 32767)));
    

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, -1, -1, 32767)
      .addComponent(jPanel2, -1, -1, 32767));
    
    layout.setVerticalGroup(layout
      .createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addComponent(jPanel1, -2, 239, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jPanel2, -2, -1, -2)
      .addContainerGap(-1, 32767)));
    

    pack();
  }
  

  private void jCheckBox_NagleActionPerformed(ActionEvent evt) {}
  
  private void jButton_StartStopActionPerformed(ActionEvent evt)
  {
    if (jButton_StartStop.getText().equalsIgnoreCase("Start transmission")) {
      jButton_StartStop.setText("Stop transmission");
      jTextField_addr.setEnabled(false);
      jButton1.setEnabled(false);
      jButton_Refresh.setEnabled(false);
      jComboBox_Addresses.setEnabled(false);
      jSpinner_Port.setEnabled(false);
      jCheckBox_Nagle.setEnabled(false);
      jSlider_BufferSize.setEnabled(false);
      currentListBoxItem = jComboBox_Addresses.getSelectedIndex();
      TCPvsUDPSender.startSenders(String.valueOf(jComboBox_Addresses.getSelectedItem()), jCheckBox_Nagle.isSelected(), jSlider_BufferSize.getValue());
    }
    else if (jButton_StartStop.getText().equalsIgnoreCase("Stop transmission")) {
      UDP_Multicast_Receiver.refreshAddressList();
      jButton_StartStop.setText("Start transmission");
      jTextField_addr.setEnabled(true);
      jButton1.setEnabled(true);
      jButton_Refresh.setEnabled(true);
      jComboBox_Addresses.setEnabled(true);
      jSpinner_Port.setEnabled(true);
      jCheckBox_Nagle.setEnabled(true);
      jSlider_BufferSize.setEnabled(true);
      TCPvsUDPSender.stopSenders();
    }
  }
  
  private void jSlider_BufferSizeStateChanged(ChangeEvent evt)
  {
    jLabel4Slider.setText("" + jSlider_BufferSize.getValue() + " bytes");
  }
  
  private void jSlider_BufferSizePropertyChange(PropertyChangeEvent evt)
  {
    jLabel4Slider.setText("" + jSlider_BufferSize.getValue() + " bytes");
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    String addr = jTextField_addr.getText() + ":" + jSpinner_Port.getValue();
    java.util.Set<String> set = new java.util.HashSet(UDP_Multicast_Receiver.userAddedAddresses);
    if (set.contains(addr)) {
      javax.swing.JOptionPane.showMessageDialog(null, "Address " + addr + " has already been on the list.", " ", 1);
      return;
    }
    UDP_Multicast_Receiver.userAddedAddresses.add(addr);
    UDP_Multicast_Receiver.refreshAddressList();
  }
  

  private JLabel jLabel_TCPThread;
  private JLabel jLabel_UDPThread;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JSlider jSlider_BufferSize;
  private JSpinner jSpinner_Port;
  private JTextField jTextField_addr;
  private void jButton_RefreshActionPerformed(ActionEvent evt) {}
  
  public static void main(String[] args)
  {
    try
    {
      for (UIManager.LookAndFeelInfo info : ) {
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
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      Logger.getLogger(MainJDialog.class.getName()).log(Level.SEVERE, null, ex);
    }
    


    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        MainJDialog dialog = new MainJDialog(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter()
        {
          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }
  
  public void UpdateGUI() {
    updateComboWithAddresses();
    if (!TCPvsUDPSender.isStarted) {
      jLabel_TCPThread.setForeground(Color.red);
      jLabel_TCPThread.setText("TCP thread: disconnected");
      jLabel_UDPThread.setForeground(Color.red);
      jLabel_UDPThread.setText("UDP thread: stopped");
      return;
    }
    









    if (TCPvsUDPSender.getSender("TCP").isConnected()) {
      jLabel_TCPThread.setForeground(Color.green);
      jLabel_TCPThread.setText("TCP thread: connected");
    }
    else {
      jLabel_TCPThread.setForeground(Color.red);
      jLabel_TCPThread.setText("TCP thread: disconnected");
    }
    if (TCPvsUDPSender.getSender("UDP").isConnected()) {
      jLabel_UDPThread.setForeground(Color.green);
      jLabel_UDPThread.setText("UDP thread: started");
    }
    else {
      jLabel_UDPThread.setForeground(Color.red);
      jLabel_UDPThread.setText("UDP thread: stopped");
    }
  }
  
  private void updateComboWithAddresses() {
    ArrayList addresses = UDP_Multicast_Receiver.getAddressList();
    
    if (UDP_Multicast_Receiver.addressesChanged == true) {
      UDP_Multicast_Receiver.addressesChanged = false;
      jComboBox_Addresses.removeAllItems();
      for (int i = 0; i < addresses.size(); i++)
        jComboBox_Addresses.addItem((String)addresses.get(i));
      if (currentListBoxItem >= jComboBox_Addresses.getItemCount())
        currentListBoxItem = (jComboBox_Addresses.getItemCount() - 1);
      jComboBox_Addresses.setSelectedIndex(currentListBoxItem);
    }
    if (jComboBox_Addresses.getItemCount() == 0) {
      jButton_StartStop.setEnabled(false);
      currentListBoxItem = 0;
    }
    else {
      jButton_StartStop.setEnabled(true);
    }
  }
}

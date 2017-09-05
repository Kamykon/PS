package sobieradzik;

import java.util.logging.Level;
import java.util.logging.Logger;








public class GUIThread
  extends Thread
{
  MainJDialog mf;
  
  public GUIThread(MainJDialog _mf)
  {
    mf = _mf;
  }
  
  public void run()
  {
    for (;;)
    {
      try {
        sleep(200L);
      } catch (InterruptedException ex) {
        Logger.getLogger(GUIThread.class.getName()).log(Level.SEVERE, null, ex);
      }
      mf.UpdateGUI();
    }
  }
}


import java.awt.event.*;
import javax.swing.*;

public class main{
  
  public static void main(String[] args) throws Exception{
    JFrame mainFrame = new JFrame();
    //get The Homescreen Panel from Homescreen
    HomeScreen G = new HomeScreen();
    JPanel Homescreen = G.getPanel();
    
    //get Settings Panel
    Setting Stemp = new Setting();
    JPanel S = Stemp.getPanel();

    //Btn to switch to other menu
    JButton SettingBtn = new JButton("goSettingsprop");
    SettingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                  mainFrame.getContentPane().remove(Homescreen);
                  mainFrame.add(S);
                  mainFrame.getContentPane().revalidate();
                  mainFrame.getContentPane().repaint();
                } catch (Exception ex) {
                  System.out.println("Something went wrong trying to download ");
                }
            }
    });

    

    Homescreen.add(SettingBtn);
    mainFrame.add(Homescreen);
    mainFrame.setSize(300,300);
    mainFrame.show();
    }
  
}

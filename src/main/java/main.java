
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class main{
  public static void main(String[] args) throws Exception{

    //basic Window config
    JFrame mainFrame = new JFrame("Youtube Downloader");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //get The Homescreen Panel from Homescreen
    HomeScreen G = new HomeScreen();
    JPanel Homescreen = G.getPanel();
    // Setze Constraints 
    GridBagConstraints c = new GridBagConstraints();
    //get Settings Panel
    Setting Stemp = new Setting();
    JPanel S = Stemp.getPanel();
    JButton HomeBtn = new JButton("Go Home");

    //funktion für go home Knopf
    HomeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                  mainFrame.getContentPane().remove(S);
                  mainFrame.add(Homescreen);
                  mainFrame.getContentPane().revalidate();
                  mainFrame.getContentPane().repaint();

                } catch (Exception ex) {
                  System.out.println("Something went wrong trying to go to homescreen");
                }
            }

    });
    //Btn to switch to Settings 
    JButton SettingBtn = new JButton("Go Settings");
    SettingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                  mainFrame.getContentPane().remove(Homescreen);
                  mainFrame.add(S);
                  mainFrame.getContentPane().revalidate();
                  mainFrame.getContentPane().repaint();

                } catch (Exception ex) {
                  System.out.println("Something went wrong trying to acces Settings ");
                }
            }
    });
    //Swing Config
    c.gridy = 4;
    c.ipadx = 150;
    c.ipady =20;
    c.insets = new Insets(100,0,0,0);
    S.add(HomeBtn,c);

    c.insets = new Insets(100,0,0,0);
    c.gridy = 5;
    Homescreen.add(SettingBtn,c);
    mainFrame.add(Homescreen);
    mainFrame.setSize(3000,3000);
    mainFrame.show();
    }
  
}


import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
public class main{
  public static void main(String[] args) throws Exception{
    JFrame mainFrame = new JFrame("Youtube Downloader");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //get The Homescreen Panel from Homescreen
    HomeScreen G = new HomeScreen();
    JPanel Homescreen = G.getPanel();
       
    GridBagConstraints c = new GridBagConstraints();
    //get Settings Panel
    Setting Stemp = new Setting();
    JPanel S = Stemp.getPanel();
    JButton HomeBtn = new JButton("Go Home");


    HomeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                  mainFrame.getContentPane().remove(S);
                  mainFrame.add(Homescreen);
                  mainFrame.getContentPane().revalidate();
                  mainFrame.getContentPane().repaint();

                } catch (Exception ex) {
                  System.out.println("Something went wrong trying to download ");
                }
            }

    });
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
    c.gridy = 3;
    c.ipadx = 150;
    c.ipady =20;
    c.insets = new Insets(100,0,0,0);
    S.add(HomeBtn,c);

    c.insets = new Insets(0,0,0,0);
    c.gridy = 5;
    Homescreen.add(SettingBtn,c);
    mainFrame.add(Homescreen);
    mainFrame.setSize(3000,3000);
    mainFrame.show();
    }
  
}

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.*;

import com.github.felipeucelli.javatube.StreamQuery;
import com.github.felipeucelli.javatube.Youtube;

import com.github.felipeucelli.javatube.*;


public class HomeScreen{
    // java.swing is bullshit
    JPanel p = new JPanel ();
    GridBagConstraints c = new GridBagConstraints();
    

    boolean isAlive = true;
    public Properties getSettings() throws Exception{ FileReader reader = new FileReader("src/main/java/config.properties");
        Properties Settings = new Properties();
        Settings.load(reader);
        return Settings;
    }
     
    public void Download(String videoURL) throws Exception{

        
        Youtube yt = new Youtube(videoURL);
        
        String DLpath = getSettings().getProperty("DLpath");
        String Choice = getSettings().getProperty("Format");
        if(Choice.equals("onlyAudio")){
          yt.streams().getOnlyAudio().download(DLpath);
                  
          System.out.println(Choice + DLpath);
        }
        if(Choice.equals("360p audio and video")){
          yt.streams().getDefaultResolution().download(DLpath);

          System.out.println(Choice + DLpath);
        }
        if(Choice.equals("video and music seperatly highest Quality")){
                
          yt.streams().getOnlyAudio().download(DLpath);
          
          Youtube ytz = new Youtube(videoURL);
          ytz.streams().getHighestResolution().download(DLpath);
          System.out.println(Choice + DLpath);
        }
        else{
          System.out.print("TS broken FR"+Choice);
        }
    
    }

    HomeScreen(){
        //alle Elemente werden deklariert 
        p.setLayout(new GridBagLayout());
        JButton DLbtn = new JButton("Download");  
        JTextField URlinput = new JTextField(8);
        JLabel Label = new JLabel("Paste URL above");


        //Swing magic
        c.ipady = 50;
        c.ipadx = 200;
        c.gridy = 3;
        c.gridx = 0;
      
        c.gridheight =5;
        c.fill = GridBagConstraints.HORIZONTAL;
        p.add(URlinput,c);
        c.gridy = 4;
        c.weightx = 0;
        p.add(Label,c);
        
        
        c.gridy = 3;
        c.ipadx = 50;
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        p.add(DLbtn,c);



        // Den Knöpfen werden Methoden zu gewiesen
        DLbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                Download(URlinput.getText());
                } catch (Exception ex) {
                  System.out.println("Something went wrong trying to download ");
                }
            }
        });
        
        //p.add(DLbtn); 
        //p.add(URlinput);
        
    }
    public JPanel getPanel(){
      return p;
    }
    
}

import java.util.*;
import java.io.*;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

import com.github.felipeucelli.javatube.StreamQuery;
import com.github.felipeucelli.javatube.Youtube;

import com.github.felipeucelli.javatube.*;


public class HomeScreen{
    
    JPanel p = new JPanel();
    boolean isAlive = true;
    public Properties getSettings() throws Exception{ FileReader reader = new FileReader("src/main/java/config.properties");
        Properties Settings = new Properties();
        Settings.load(reader);
        return Settings;
    }
    
    public void Download(String videoURL) throws Exception{
        Youtube yt = new Youtube(videoURL);
        String DLpath = getSettings().getProperty("DLpath");
        //yt.streams().getHighestResolution().download(DLpath);
        yt.streams().getOnlyAudio().download(DLpath);
        

    
    }

    HomeScreen(){
        //alle Elemente werden deklariert 
        p.setLayout(new GridLayout(4,4));
        JButton DLbtn = new JButton("Download");  
        JCheckBox PlaylistCheck = new JCheckBox("Download entire Playlist");
        JTextField URlinput = new JTextField(8);

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

        p.add(DLbtn); 
        p.add(PlaylistCheck);
        p.add(URlinput);
        
    }
    public JPanel getPanel(){
      return p;
    }
    
}

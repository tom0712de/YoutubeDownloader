import java.awt.event.*; import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.util.*;
import java.io.*;


public class Setting{

  Properties Settings = new Properties();
  public void saveSettings() throws Exception{
    try(FileWriter writer = new FileWriter("src/main/java/config.properties")){
      Settings.setProperty("DLpath", DLpath.getText());
     // add func to write to file writer.write(Settings);

    }catch(IOException e){
      System.out.println("error trying to save settings");
    }
  }   
  public Setting(){
     
    // load Settings
    try(FileReader reader = new FileReader("src/main/java/config.properties")){
      
        Settings.load(reader);
    }
    catch(IOException e){
      System.out.print("Error trying to load Setting file");
    }
  
    // create GUI Elements
    JPanel p = new JPanel();
    JTextField DLpath = new JTextField(8);
    // add Layout p.setLayout(new BoxLayout());
    JButton Confirmbtn = new JButton("Confirm");
    p.add(DLpath);
    p.add(Confirmbtn);
    
    DLpath.addActionListener(new ActionListener(){
      @override
      public void actionPerformed(ActionEvent e){
        try{
          saveSettings();
        }catch(Exception e){
          System.out.println("Error trying to save File");
        }
      }});
    
    
    
  } 
} 

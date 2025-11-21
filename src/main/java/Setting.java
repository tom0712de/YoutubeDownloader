import java.awt.event.*; import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.util.*;
import java.io.*;


public class Setting{
  
  JTextField DLpath = new JTextField(8);
  Properties Settings = new Properties();
  JPanel p = new JPanel();


  //
  public JPanel getPanel(){
    return p; 
  }


  public void saveSettings() throws Exception{
    try(FileWriter writer = new FileWriter("src/main/java/config.properties")){
      Settings.setProperty("DLpath", DLpath.getText());
     // add func to write to file writer.write(Settings);
      Settings.store(writer,"");

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
    // add Layout p.setLayout(new BoxLayout());
    JButton Confirmbtn = new JButton("Confirm");
    p.add(DLpath);
    p.add(Confirmbtn);
    
    Confirmbtn.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        try{
          saveSettings();
        }catch(Exception IE){
          System.out.println("Error trying to save File");
        }
      }});
    
    
    
  } 
} 

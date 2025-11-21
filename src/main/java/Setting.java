import java.awt.event.*; import java.util.Scanner;

import javax.swing.*;

import java.util.*;
import java.io.*;


public class Setting{
  
  JTextField DLpath = new JTextField(8);
  Properties Settings = new Properties();
  JPanel p = new JPanel();
  JPanel Pathp = new JPanel();
  
  JPanel Formatp = new JPanel();
  //
  public JPanel getPanel(){
    p.add(Pathp);
    p.add(Formatp);
    return p; 
  }


  public void saveSettings() throws Exception{
    try(FileWriter writer = new FileWriter("src/main/java/config.properties")){
     // add func to write to file writer.write(Settings);
      Settings.store(writer,"");

    }catch(IOException e){
      System.out.println("error trying to save settings");
    }
  } 
  
  public Setting(){
    

    //Setup Format dropdown
    String [] Choices = {"360p audio and video","video and music seperatly highest Quality","onlyAudio"};
    JComboBox<String> CBFormat = new JComboBox(Choices);
    JButton FormatBtn = new JButton("confirm");
    Formatp.add(CBFormat);
    Formatp.add(FormatBtn);


    // load Settings
    try(FileReader reader = new FileReader("src/main/java/config.properties")){
        Settings.load(reader);
    }
    catch(IOException e){
      System.out.print("Error trying to load Setting file");
    }
 

    // create GUI Elements for Path 
    JButton Confirmbtn = new JButton("Confirm");
    Pathp.add(DLpath);
    Pathp.add(Confirmbtn);
    

    //add func to Confirm BTN
    Confirmbtn.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        try{

          Settings.setProperty("DLpath", DLpath.getText());
          saveSettings();
        }catch(Exception IE){
          System.out.println("Error trying to save File");
        }
      }});
    
    //add func to Confirm  BTN Format
    FormatBtn.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        try{
          String t = (String)CBFormat.getSelectedItem();
          Settings.setProperty("Format",t);
          saveSettings();
        }catch(Exception IE){
          System.out.println("Error trying to save File");
        }
      }});
    
    
  } 
} 

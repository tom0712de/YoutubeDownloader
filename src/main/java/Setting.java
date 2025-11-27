import java.awt.event.*; 

import java.awt.*;
import javax.swing.*;

import java.util.*;
import java.io.*;


public class Setting{
  JTextField maxThread = new JTextField();
  JButton threadBtn = new JButton("Confirm");
  JCheckBox  isPlaylist = new JCheckBox("Download full Playlist");
  String [] Choices = {"360p audio and video","video and music seperatly highest Quality","onlyAudio"};
  JComboBox<String> CBFormat = new JComboBox(Choices);
  JTextField DLpath = new JTextField(8);
  Properties Settings = new Properties();
  JPanel p = new JPanel();
  GridBagConstraints c = new GridBagConstraints();
  JPanel Formatp = new JPanel();

  //
  public JPanel getPanel(){
    syncSettings();
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
  //add method for syncing settings with file
  public void syncSettings(){
    System.out.print(Boolean.parseBoolean(Settings.getProperty("isPlaylist")));
    isPlaylist.setSelected(Boolean.parseBoolean(Settings.getProperty("isPlaylist")));
    CBFormat.setSelectedItem(Settings.getProperty("Format"));
    DLpath.setText(Settings.getProperty("DLpath"));

    maxThread.setText(Settings.getProperty("maxThread"));
    System.out.println("SettingsSynceld");
    }
  public Setting(){

    p.setLayout(new GridBagLayout());
    //Setup Format dropdown
    JButton FormatBtn = new JButton("confirm");

    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(0,10,20,0);
    c.gridy = 0;
    c.gridx = 0;
    c.ipadx = 200;
    c.ipady = 50;
    p.add(CBFormat,c);

    c.gridx = 1;
    c.ipadx = 50;
    
    p.add(FormatBtn,c);


    // load Settings
    try(FileReader reader = new FileReader("src/main/java/config.properties")){
        Settings.load(reader);
    }
    catch(IOException e){
      System.out.print("Error trying to load Setting file");
    }
    CBFormat.setSelectedItem(Settings.getProperty("Format"));
    DLpath.setText(Settings.getProperty("DLpath"));
    // create GUI Elements for Path 
    JButton Confirmbtn = new JButton("Confirm");
    c.gridy = 1;
    c.gridx = 0;
    c.ipadx = 200;
    c.ipady = 50;
    p.add(DLpath,c);

    c.gridx = 1;
    c.ipadx = 50;
    p.add(Confirmbtn,c); 
    
    c.gridx = 0;
    c.gridy = 4;
    c.ipadx = 50;
    p.add(maxThread,c);
    c.gridx=1;
    c.ipadx = 50;
    p.add(threadBtn,c);

    //Setup is Playlist   

    isPlaylist.setSelected(Boolean.parseBoolean(Settings.getProperty("isPlaylist")));
    c.gridx = 0;
    c.gridy = 3;
    c.ipadx = 50;
    c.ipady = 50;
    p.add(isPlaylist,c);
    JButton ABtn = new JButton("Confirm");
    
    c.gridx = 1;
    p.add(ABtn,c);
    
    
    ABtn.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        try{
          String temp;
       if(isPlaylist.isSelected()){
            temp = "true";
          }else{
            temp = "false";
          }

          Settings.setProperty("isPlaylist",temp);
          saveSettings();
        }catch(Exception IE){
          System.out.println("Error trying to save File");
        }
      }});   
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
    
   
   threadBtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          try{

            Settings.setProperty("maxThread",maxThread.getText());
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
          System.out.println("Error Trying to change format");  
        }
      }});
  }}

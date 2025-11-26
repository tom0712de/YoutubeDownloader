import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.github.felipeucelli.javatube.*;


public class HomeScreen{
    // java.swing is bullshit
    JPanel p = new JPanel ();
    GridBagConstraints c = new GridBagConstraints();
        
    boolean isAlive = true;
    
//function to get Settings from the File
    public Properties getSettings() throws Exception{ FileReader reader = new FileReader("src/main/java/config.properties");
        Properties Settings = new Properties();
        Settings.load(reader);
        return Settings;
    }


//func to Download
    public void Download(String videoURL) throws Exception{
        Youtube yt = new Youtube(videoURL);
        
        String DLpath = getSettings().getProperty("DLpath");
        String Choice = getSettings().getProperty("Format");
        System.out.println(DLpath);
        

        if(Choice.equals("onlyAudio")){
          yt.streams().getOnlyAudio().download(DLpath);
                  
        }
        if(Choice.equals("360p audio and video")){
          yt.streams().getDefaultResolution().download(DLpath,"musicFile.mp4");

        }
        if(Choice.equals("video and music seperatly highest Quality")){
                
          
          Youtube ytz = new Youtube(videoURL);
          ytz.streams().getHighestResolution().download(DLpath,"video");
        }
        else{
          System.out.print("TS broken FR Wrong Format choice"+Choice);
        }
    }


    HomeScreen(){  //Constructer 
      //Gui Elemente 
        p.setLayout(new GridBagLayout());
        JButton DLbtn = new JButton("Download");  
        JTextField URlinput = new JTextField(8);
        JLabel Label = new JLabel("Paste URL above");


        //Swing magic
        c.ipady = 50;
        c.ipadx = 200;
        c.gridy = 3;
        c.gridx = 0;
        c.insets = new Insets(0,10,0,0); 
        c.fill = GridBagConstraints.HORIZONTAL;
        p.add(URlinput,c);

        c.insets = new Insets(0,0,0,0); 
        c.gridy = 4;
        p.add(Label,c);
        
        c.gridy = 3;
        c.ipadx = 50;
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        p.add(DLbtn,c);



        // Den Knöpfen werden Methoden zu gewiesen
        
        //Download BTn
        DLbtn.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                try{

                  boolean isPlayList = Boolean.parseBoolean(getSettings().getProperty("isPlaylist"));
                  if(isPlayList){ // value is wrong boolean parse prolly bs
                    System.out.println("trying to download playlist");
                    try{
                      ArrayList<String> arr = new Playlist(URlinput.getText()).getVideos();
                      for(int i = 0;i<arr.size();i++){
                        Download(arr.get(i));
                      }
                    }
                    catch(Exception Es){
                      System.out.println("No Playlista");
                    }
                  }else{
                    Dlthread t = new Dlthread(URlinput.getText(),getSettings());
                    t.start();
                    //              Download(URlinput.getText());
                  }
                } catch (Exception ex) {
                  System.out.println("Something went wrong trying to download ");
                }
                }
              }
        );
       //[{{{{)         
        
    }
    public JPanel getPanel(){
      return p;
    }
    
}

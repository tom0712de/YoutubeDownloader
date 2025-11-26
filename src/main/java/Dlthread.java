import java.util.*;

import com.github.felipeucelli.javatube.*;
public class Dlthread extends Thread{
  private String url;
  private Properties Setting;
  public Dlthread(String url,Properties pSettings){
    this.url = url;
    this.Setting = pSettings;
  }
  public void Download() throws Exception{
    String DLpath = Setting.getProperty("DLpath");
    String Choice = Setting.getProperty("Format");
     
    Youtube yt = new Youtube(this.url);


    if(Choice.equals("onlyAudio")){
      yt.streams().getOnlyAudio().download(DLpath);
              
    }
    if(Choice.equals("360p audio and video")){
      yt.streams().getDefaultResolution().download(DLpath,"musicFile.mp4");

    }
    if(Choice.equals("video and music seperatly highest Quality")){
            
      
      Youtube ytz = new Youtube(this.url);
      ytz.streams().getHighestResolution().download(DLpath,"video");
    }
  }
  @Override
  public void run(){
     try{
      Download();
     }catch(Exception e){
     System.out.print("something went wrong while download");
     } 
  }
}

import java.util.Scanner;
import java.util.*;
import java.io.*;



import com.github.felipeucelli.javatube.Youtube;

public class tui {
    private static Scanner inputScan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        System.out.println("Type 1 for download Video");
        String input = inputScan.nextLine();
        
        if (input.equals("1")){
            Download();
        }

    }
    public static Properties getSettings() throws Exception{
        FileReader reader = new FileReader("src/main/java/config.properties");
        Properties Settings = new Properties();
        Settings.load(reader);
        return Settings;

   
    }
    public static void Download() throws Exception{
        
        System.out.println("Video Url eingeben");
        String videoURL = inputScan.nextLine();
        Youtube yt = new Youtube(videoURL);
        String DLpath = getSettings().getProperty("DLpath");
        yt.streams().getHighestResolution().download(DLpath);
        
    }
    
}

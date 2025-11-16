

import com.github.felipeucelli.javatube.Youtube;

import java.util.Scanner;
public class Main{


public static void main(String[] args) throws Exception {
    Scanner URLscanner = new Scanner(System.in);
    System.out.println("Enter video URl");
    String videoUrl = URLscanner.nextLine();
    Youtube yt = new Youtube(videoUrl);
    yt.streams().getHighestResolution().download();
    
}

}

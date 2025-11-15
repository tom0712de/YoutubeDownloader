import com.github.felipeucelli.javatube.Youtube;
public class Main{


public static void main(String[] args) throws Exception {
    Youtube yt = new Youtube("https://www.youtube.com/watch?v=2lAe1cqCOXo");
    yt.streams().getHighestResolution().download();
}
}
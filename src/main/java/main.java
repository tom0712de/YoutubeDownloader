import javax.swing.JFrame;

public class main{
  public static void main(String[] args) throws Exception{
    JFrame mainFrame = new JFrame();
    HomeScreen G = new HomeScreen();
    mainFrame.add(G.getPanel());
    mainFrame.setSize(300,300);
    mainFrame.show();
    while(g.isAlive){
    }
    mainFrame.getContentPane().removeAll();
  }
}

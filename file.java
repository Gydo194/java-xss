import java.io.*;
import java.nio.*;
import javax.swing.*;
import java.util.Scanner;
import java.lang.Thread;

public class file {
    
    public class run implements Runnable {
        public void run() {
            try {
            runDbDialog();
            }
            catch(IOException i) {
                System.out.println("IOEXCEPTION in run.run()");
                System.exit(0);
            }
            catch(InterruptedException v) {
                System.out.println("InterruptedException in run.run()");
                System.exit(0);
            }
            
        }
    }
    
    public static class frameThread extends Thread {
        public void run() {
            try {
            runDbDialog();
            }
        catch(IOException e) {
            System.out.println("IOEXCEPTION");
            System.exit(0);
        }
            catch(InterruptedException b){
                System.out.println("InterruptedException in frameThread.run()");
                System.exit(0);
            }
        }
        
    }
    

public static void runDbDialog() throws IOException, InterruptedException {
 
  
   
    
    
    JFrame frame = new JFrame("database");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Loading...");
    panel.add(label);
    frame.add(panel);
    frame.setSize(200,300);
    frame.setVisible(true);
    
    
    
    while(true){
    String text = "<html>";
    Scanner in = new Scanner(new FileReader("/Applications/XAMPP/xamppfiles/htdocs/postback.csv"));
    in.useDelimiter(",");
    while(in.hasNext()){
        String next = in.next();
        text = text + next + "<br>";
        
    }
    text = text + "</p></html>";
    label.setText(text);
        Thread.sleep(200);
       
    
    }
   
   
    
}

    public static void main(String[] args) throws IOException, InterruptedException {
        frameThread dialog0 = new frameThread();
        dialog0.start();
    }

}

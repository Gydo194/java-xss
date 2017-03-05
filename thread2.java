import javax.swing.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;




public class thread2 implements Runnable {
    private JFrame dbFrame = new JFrame("Database");
    private JPanel dbPanel = new JPanel();
    private JLabel dbLabel = new JLabel("loading or access error");
    
    public void run() {
        try {
        dbFrame.add(dbPanel);
        dbPanel.add(dbLabel);
        dbFrame.setSize(200,300);
                String html;
        dbFrame.setVisible(true);
        
        while(true){
            
            Scanner in = new Scanner(new FileReader("/Applications/XAMPP/htdocs/postback.csv"));
            in.useDelimiter(",");

            
            html = "<html>";
            while(in.hasNext()){
                html = html + in.next() + "<br>";
            }
            html = html + "</html>";
            dbLabel.setText(html);
            System.out.println(html);
            System.out.println(Thread.currentThread().getId());
            in.close();
            Thread.sleep(200);
            
        }
    }
        catch(IOException e) {
            System.out.println("Caught IOException, printing stacktrace...");
            e.printStackTrace();
            
        }
        //catch(FileNotFoundException e) {
            
        //}
        catch(InterruptedException e){
            System.out.println("Caught InterruptedException.");
        }
    }
    
    
    public void hide() {
        dbLabel.setVisible(false);
    }
    
    
    
    public static void main(String args[] ) {
        Thread t = new Thread(new thread2());
        t.start();
    }
    }

import javax.swing.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.nio.file.Files;




public class Java_XSS implements Runnable {
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
        Thread postbackDatabaseDialogThread = new Thread(new Java_XSS());
        postbackDatabaseDialogThread.start();
        
        
        JFrame wdLocationFrame = new JFrame("Java XSS:Working Directory");
        String wd = JOptionPane.showInputDialog(wdLocationFrame, "Enter working directory path: ");
        
        
        JFrame executingFrame = new JFrame("Java XSS: Executing command");
        JPanel executingPanel = new JPanel();
        JLabel executingLabel = new JLabel("Loading");
        executingFrame.add(executingPanel);
        executingPanel.add(executingLabel);
        executingFrame.setSize(400,100);
        
        try {
            
            while(true){
        
        JFrame commandInputDialog = new JFrame("Java XSS");
        String command = JOptionPane.showInputDialog(commandInputDialog,"Enter command");
        executingFrame.setVisible(true);
        Files.write(Paths.get(wd + "/event.txt"),command.getBytes());
        Thread.sleep(7500);
        Files.delete(Paths.get(wd + "/event.txt"));
        executingFrame.setVisible(false);
                
            }
        }
        catch(IOException e){
            System.out.println("ioexception");
        }
        catch(InterruptedException e){
            System.out.println("interruptedexception");
        }
    }
    }

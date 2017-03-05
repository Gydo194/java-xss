import javax.swing.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.File;




public class Java_XSS implements Runnable {
    private JFrame dbFrame = new JFrame("Database");
    private JPanel dbPanel = new JPanel();
    private JLabel dbLabel = new JLabel("loading or access error");
    
    String wdPath = "";
    
    public void setPath(String path){
        wdPath = path;
        System.out.println("setPath: path=" + path + " , wdPath = " + wdPath);
    }
    
    public void run() {
        try {
        dbFrame.add(dbPanel);
        dbPanel.add(dbLabel);
        dbFrame.setSize(200,300);
                String html;
        dbFrame.setVisible(true);
            System.out.println("Database handler starting thread ID " + Thread.currentThread().getId());
        
        while(true){
            
            
            
            Scanner in = new Scanner(new FileReader(wdPath + "/postback.csv"));
            in.useDelimiter(",");

            
            html = "<html>";
            while(in.hasNext()){
                html = html + in.next() + "<br>";
            }
            html = html + "</html>";
            dbLabel.setText(html);
            //System.out.println(html);
            //System.out.println(Thread.currentThread().getId());
            in.close();
            Thread.sleep(200);
            
        }
    }
        catch(IOException e) {
            System.out.println("Caught IOException, printing stacktrace...");
            e.printStackTrace();
            System.exit(-1);
            
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
        
        
        JFrame wdLocationFrame = new JFrame("Java XSS:Working Directory");
        String wd = JOptionPane.showInputDialog(wdLocationFrame, "Enter working directory path: ");
        
        //check wether files exist, if not create them
        try{
        File postbackCsvFile = new File(wd + "/postback.csv");
        if(!postbackCsvFile.exists()){
            Files.write(Paths.get(wd + "/postback.csv"), "".getBytes());
            System.out.println("Creating file " + wd + "/postback.csv");
        }
        }
        catch(IOException e){
            System.out.println("ioexception");
        }
        
        
        
        
        Java_XSS postbackDatabaseThreadObject = new Java_XSS();
        postbackDatabaseThreadObject.setPath(wd);
        Thread postbackDatabaseThread = new Thread(postbackDatabaseThreadObject);
        postbackDatabaseThread.start();
        
        
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
                
                
               
        if(command == null){
            System.out.println("Cancel pressed, exiting...");
            System.exit(0);
        }
        System.out.println(command);
        executingLabel.setText("Executing: " + command);
        executingFrame.setLocationRelativeTo(null);
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

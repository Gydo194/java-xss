import javax.swing.*;
import java.io.IOException;
import java.io.Console;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.util.Scanner;
import java.io.FileReader;

public class java_xss_gui {
    
    
    
    
    
    public static void main(String [] args) throws IOException, InterruptedException {
        
        JFrame locationFrame = new JFrame("Java-XSS GUI v1.0");
        String commandFileLocation = JOptionPane.showInputDialog(locationFrame, "Commandfile directory:");
        System.out.println(commandFileLocation);
        
        
        JFrame dbFrame = new JFrame("Post-back database");
        JPanel dbContentPanel = new JPanel();
        JLabel dbContentlabel = new JLabel("Loading...");
        dbContentPanel.add(dbContentlabel);
        dbFrame.add(dbContentPanel);
        dbFrame.setSize(200,300);
        
        
        Scanner rawDbInputScanner = new Scanner(new FileReader(commandFileLocation + "/postback.csv"));
        rawDbInputScanner.useDelimiter(",");
        
        
        
        while(true){
            JFrame commandDialog = new JFrame("Java-XSS");
            String command = JOptionPane.showInputDialog(commandDialog, "Enter command to execute:");
            System.out.println(command);
           
            JPanel executingPanel = new JPanel();
            JLabel panelText = new JLabel(command);
            executingPanel.add(panelText);
            JFrame executingFrame = new JFrame("Java-XSS GUI: Executing command");
            dbFrame.setVisible(true);
            
            
            if(command != null){
                executingFrame.add(executingPanel);
                executingFrame.setSize(400,100);
                executingFrame.setLocationRelativeTo(null);
                executingFrame.setVisible(true);
                Files.write(Paths.get(commandFileLocation + "/event.txt"), command.getBytes());
                Thread.sleep(7500);
                Files.write(Paths.get(commandFileLocation + "/event.txt"), "".getBytes());
                
                String htmlEncodedDbContent = "<html>";
                while(rawDbInputScanner.hasNext()) {
                    String inData = rawDbInputScanner.next();
                    htmlEncodedDbContent = htmlEncodedDbContent + inData + "<br>";
                    System.out.println(inData);
                    
                }
                
                htmlEncodedDbContent = htmlEncodedDbContent + "</html>";
                System.out.println("htmlEncodedDbContent: " + htmlEncodedDbContent + "/htmlEncodedDbContent");
                
                dbContentlabel.setText(htmlEncodedDbContent);
                
                executingFrame.setVisible(false);
                
                
                
    
                
            }
            else
            {
                System.out.println("Cancel pressed, Exiting.");
                System.exit(0);
            }
        }
    }
}


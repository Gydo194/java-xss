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
            
            
        }}
    
    
    
    public static void main(String [] args) throws IOException, InterruptedException {
        //runDbDialog();
        JFrame locationFrame = new JFrame("Java-XSS GUI v1.0");
        String commandFileLocation = JOptionPane.showInputDialog(locationFrame, "Commandfile directory:");
        System.out.println(commandFileLocation);
        while(true){
            JFrame commandDialog = new JFrame("Java-XSS");
            String command = JOptionPane.showInputDialog(commandDialog, "Enter command to execute:");
            System.out.println(command);
           
            JPanel executingPanel = new JPanel();
            JLabel panelText = new JLabel(command);
            executingPanel.add(panelText);
            JFrame executingFrame = new JFrame("Java-XSS GUI: Executing command");
            if(command != null){
                executingFrame.add(executingPanel);
                executingFrame.setSize(400,100);
                executingFrame.setLocationRelativeTo(null);
                executingFrame.setVisible(true);
                Files.write(Paths.get(commandFileLocation + "/event.txt"), command.getBytes());
                Thread.sleep(7500);
                Files.write(Paths.get(commandFileLocation + "/event.txt"), "".getBytes());
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


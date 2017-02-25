import javax.swing.*;
import java.io.IOException;
import java.io.Console;
import java.io.file.Files;
import java.io.file.Paths;

public class java_xss_gui {
    public static void main(String [] args) throws IOException, InterruptedException {
        JFrame locationFrame = new JFrame("Java-XSS GUI v1.0");
        String commandFileLocation = JOptionPane.showInputDialog(locationFrame, "Commandfile location:");
        System.out.println(commandFileLocation);
        commandFile = new FIle(commandFileLocation);
        
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
                Files.write(Paths.get(commandFileLocation), command.getBytes());
            Thread.sleep(7500);
                Files.write(Paths.get(commandFileLocation), "".getBytes());
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
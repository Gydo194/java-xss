import javax.swing.*;
import java.io.IOException;


public class java_xss_gui {
    public static void main(String [] args) {
        JFrame locationFrame = new JFrame("Java-XSS GUI v1.0");
        String commandFileLocation = JOptionPane.showInputDialog(locationFrame, "Commandfile location:");
        
        while(true){
            JFrame commandDialog = new JFrame("Java-XSS");
            String command = JOptionPane.showInputDialog(commandDialog, "Enter command to execute:");
            
            JPanel executingPanel = new JPanel();
            JLabel panelText = new JLabel("Executing '" + command + "', Please wait...");
            executingPanel.setSize(300,400);
            executingPanel.add(panelText);
            executingPanel.setVisible(true);
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
  









    }
}
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
    String commandFileLocation = "/Applications/XAMPP/htdocs";
    
    
  /*
    
    public static class PostbackDialogHandler {
        JFrame dbFrame = new JFrame("Database");
        JPanel dbContentPanel = new JPanel();
        JLabel dbContentLabel = new JLabel("Loading...");
        
        public static void show() {
            dbContentPanel.add(dbContentLabel);
            dbFrame.add(dbContentPanel);
            dbFrame.setSize(200,300);
            dbFrame.setVisible(true);
        }
        public static void hide() {
            dbFrame.setVisible(false);
        }
        public static JFrame getId() {
            return dbContentLabel;
        }
    }
    
  */
    
    public class DbHandler implements Runnable {
        JFrame dbFrame = new JFrame("Database");
        JPanel dbPanel = new JPanel();
        JLabel dbLabel = new JLabel("Loading or Error");
        public void run() {
          
            dbFrame.add(dbPanel);
            dbPanel.add(dbLabel);
            
            dbFrame.setSize(200,300);
            dbFrame.setVisible(true);
            try {
            while(true){
                dbLabel.setText(readContent());
            }
            }
            catch(IOException e){
                System.out.println("ERROR: IOEXCEPTION CAUGHT. printing stacktrace");
                e.printStackTrace();
            }
            
            
        }
        public String readContent() throws IOException {
            Scanner in = new Scanner(new FileReader(commandFileLocation + "/postback.csv"));
            in.useDelimiter(",");
            String content = "<html>";
            while(in.hasNext()){
                content = content + in.next() + "<br>";
            }
            content = content + "</html>";
            return content;
        }
        public JLabel getId() {
            return dbLabel;
        }
        public void show(){
            dbFrame.setVisible(true);
        }
        public void hide() {
            dbFrame.setVisible(false);
        }
    }
    public static void main(String [] args) throws IOException, InterruptedException {
        
      
        JFrame locationFrame = new JFrame("Java-XSS GUI v1.0");
        String commandFileLocation = JOptionPane.showInputDialog(locationFrame, "Commandfile directory:");
        System.out.println(commandFileLocation);
        
        //File ackFile = new File(commandFileLocation + "/ackfile.txt");
      
        
        
        
        while(true){
            JFrame commandDialog = new JFrame("Java-XSS");
            String command = JOptionPane.showInputDialog(commandDialog, "Enter command to execute:");
            System.out.println(command);
           
            JPanel executingPanel = new JPanel();
            JLabel panelText = new JLabel(command);
            executingPanel.add(panelText);
            
            
            //PostbackDialogHandler postbackFrame = new PostbackDialogHandler();
           // postbackFrame.show();
           // postbackFrame.getId().setText((new String(Files.readAllBytes(Paths.get(commandFileLocation + "/postback.csv")), "UTF-8")));
            
            
           /* JFrame postbackDialogFrame = new JFrame("Database");
            JPanel postbackPanel = new JPanel();
            JLabel content = new JLabel("Loading or error");
            postbackDialogFrame.add(postbackPanel);
            postbackPanel.add(content);
            postbackDialogFrame.setSize(200,300);
            //postbackDialogFrame.setVisible(true);
            //content.setText((new String(Files.readAllBytes(Paths.get(commandFileLocation + "/postback.csv")), "UTF-8")));
            
            
            
            
            
           // Scanner in = new Scanner(new FileReader(commandFileLocation + "/postback.csv"));
           // String htmlEncodedDbContent = "<html>";
           // in.useDelimiter(",");
            while(in.hasNext()){
                htmlEncodedDbContent = htmlEncodedDbContent + in.next() + "<br>";
            }
            htmlEncodedDbContent = htmlEncodedDbContent + "</html>";
            content.setText(htmlEncodedDbContent);
            
            */
            
            JFrame executingFrame = new JFrame("Java-XSS GUI: Executing command");
            if(command != null){
                executingFrame.add(executingPanel);
                executingFrame.setSize(400,100);
                executingFrame.setLocationRelativeTo(null);
                
                
                executingFrame.setVisible(true);
                
                
                Files.write(Paths.get(commandFileLocation + "/event.txt"), command.getBytes());
                Thread.sleep(7500);
                
                
                
                Files.delete(Paths.get(commandFileLocation + "/event.txt"));
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

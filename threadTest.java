import javax.swing.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;


public class threadTest {

    public class DbHandler implements Runnable {
        private JFrame dbFrame = new JFrame("Database Viewer");
        private JPanel dbPanel = new JPanel();
        private JLabel dbLabel = new JLabel("Loading or error");
        public void run() {
            try {
            dbFrame.add(dbPanel);
            dbPanel.add(dbLabel);
            dbFrame.setSize(200,300);
            dbFrame.setVisible(true);
            while(true){
                dbLabel.setText(this.readDb());
            }
            }
            catch(FileNotFoundException e){
                System.err.println("ERROR: File doesn't exist");
                System.exit(1);
            }
            
        }
        
        public String readDb() throws FileNotFoundException {
            Scanner in = new Scanner(new FileReader("/Applications/XAMPP/htdocs/postback.csv"));
            in.useDelimiter(",");
            String text = "<html>";
            while(in.hasNext()){
                text+=in.next() + "<br>";
            }
            text += "</html>";
            return text;

        }
        public JLabel getId() {
                return dbLabel;
        }
    }
    
   // DbHandler postbackHandler = new DbHandler();
   // postbackHandler.start();
    public static void main(String args[]) {
        
        (new Thread(new DbHandler())).start();
        
    }


}

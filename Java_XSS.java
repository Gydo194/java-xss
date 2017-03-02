import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.*;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Java_XSS {
    
    static String workingDirectory = "/Applications/XAMPP/htdocs/";

    private static class PostbackDialog {
        
        private JLabel dbDialogContent = new JLabel("test");
        
        public void show() {
            System.out.println("Starting postback dialog");
            JFrame dbDialogFrame = new JFrame("Post-Back database");
            JPanel dbDialogPanel = new JPanel();
            //JLabel dbDialogContent = new JLabel("Loading");
            dbDialogFrame.add(dbDialogPanel);
            dbDialogPanel.add(dbDialogContent);
            dbDialogFrame.setSize(200,300);
            dbDialogFrame.setVisible(true);
            //return dbDialogContent;
        }
        
        public JLabel getLabel() {
            return dbDialogContent;
        }
    }
    
       


    private static PostbackDialog postback = new PostbackDialog();

    private static class StartThreads implements Runnable {
    
        public void run() {
            System.out.println("StartThreads() calling postback.show()");
            postback.show();
            postback.getLabel().setText("databaseContent");
        }
        
    }


public static void main(String[] args) {
    Thread threads = new Thread(new StartThreads());
    threads.start();
    //inputDialog ind = new inputDialog();
    //executingDialog exd = new executingDialog();
    
    
}

}

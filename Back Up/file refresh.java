import java.io.*;
import java.nio.*;
import javax.swing.*;
import java.util.Scanner;

public class file {

public static void main(String[] args) throws IOException, InterruptedException {
 
  
   
    
    
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
    
    
    }
   
    
    
}}

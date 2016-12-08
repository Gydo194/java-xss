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

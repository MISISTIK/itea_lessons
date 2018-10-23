package less01;

import java.io.Console;


public class MyLog {
    public static void main(String[] args) {
        Console console = System.console();
        if (console==null) {
            System.exit(66613);
        }
        System.out.print("ENTER LOGIN: ");
        String login = console.readLine();
        System.out.print("ENTER Password: ");
        char[] password = console.readPassword();

        if (login.equals("admin") && String.valueOf(password).equals("123")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }

}

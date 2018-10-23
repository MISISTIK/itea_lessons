package less01;

import java.util.Locale;
import java.util.ResourceBundle;

public class DZ_1 {
    public static void main(String[] args) {
            ResourceBundle conf = ResourceBundle.getBundle("config");
            ResourceBundle messages = ResourceBundle.getBundle(
                    "MessagesBundle",
                    new Locale(
                            conf.getString("language"),
                            conf.getString("country")
                    )
            );
            print("Language = " + conf.getString("language"));
            print("Country = " + conf.getString("country"));
            print("Hi = " + messages.getString("hi"));
            print("Bye = " + messages.getString("bye"));
        }

    private static void print(String s) {
        System.out.println(s);
    }
}

package less01;

import java.util.Locale;
import java.util.ResourceBundle;

public class InterM {

	public static void main(String[] args) {
		Locale curLocale=new Locale("en","US");
		//Locale curLocale=new Locale("de","DE");
		ResourceBundle messages=
	ResourceBundle.getBundle("MessagesBundle", curLocale);
		System.out.println(messages.getString("hi"));
		System.out.println(messages.getString("bye"));
	}

}

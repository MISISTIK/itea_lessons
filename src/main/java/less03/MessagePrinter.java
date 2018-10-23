package less03;

public class MessagePrinter {
	String msg = "My Message";

	public MessagePrinter(MyLambdaInterface myLambdaInterface) {
		System.out.println(myLambdaInterface.getMessage(msg));
	}
}

package less03;

public class MessageProvider implements MyLambdaInterface{

	@Override
	public String getMessage(String msg) {
		return "Interface checked text: "+msg;
	}

}

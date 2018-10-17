package less03;

public class MainLambda {

	public static void main(String[] args) {
		//MessageProvider messageProvider=new MessageProvider();
		
//		MyLambdaInterface myLambdaInterface=new MyLambdaInterface() {		
//			@Override
//			public String getMessage(String msg) {
//				return "Interface checked text: "+msg;
//			}
//		};
		
		MessagePrinter messagePrinter=
				new MessagePrinter((msg)->"sefdgsd"+msg+"kjhj");

	}

}

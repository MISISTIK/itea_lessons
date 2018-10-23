package less03;

public class SomeClass {

	public static void main(String[] args) {
//		MyInt myInt=new MyInt() {
//			@Override
//			public void someMethod() {
//				System.out.println("Hello, Max");
//				
//			}};
		//ImplementedClass ic=new ImplementedClass();
		SomeAnotherClass sac=new SomeAnotherClass();
		sac.setMyInt(()->System.out.println("Hi"));
		sac.doSomething();

	}

}

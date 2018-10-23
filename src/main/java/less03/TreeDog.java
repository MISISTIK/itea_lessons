package less03;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeDog {

	public static void main(String[] args) {
//		Comparator<Dog> dogComparator=new Comparator<Dog>() {
//			@Override
//			public int compare(Dog dog1, Dog dog2) {
//				return dog1.getAge()>dog2.getAge()?1:-1;
//			}};
			
		TreeSet<Dog> ts=new TreeSet<Dog>(
				(dog1,dog2)->dog1.getAge()>dog2.getAge()?1:-1
				);		
		ts.add(new Dog("A",10));
		ts.add(new Dog("B",1));
		ts.add(new Dog("C",5));
		System.out.println(ts);

	}

}

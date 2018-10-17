package less03;

import java.util.Comparator;

public class DogComparator implements Comparator<Dog>{

	@Override
	public int compare(Dog dog1, Dog dog2) {
		return dog1.getAge()>dog2.getAge()?1:-1;
	}

	
}

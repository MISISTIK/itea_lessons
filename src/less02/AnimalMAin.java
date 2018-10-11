package less02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AnimalMAin {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Cat cat=new Cat("Susleg",15);
		FileOutputStream fos=new FileOutputStream("mydog.bin");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(cat);
		fos.close();
		
		FileInputStream fis=new FileInputStream("mydog.bin");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Cat cloneDog=(Cat) ois.readObject();
		System.out.println(cat);
		System.out.println("Clone: "+cloneDog);

	}

}

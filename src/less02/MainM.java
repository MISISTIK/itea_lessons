package less02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainM {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		Dog dog = new Dog("Susleg", 5);
		Owner owner=new Owner("Max");
		dog.setOwner(owner);
		System.out.println(dog);
		
	//	ByteArrayOutputStream baos=new ByteArrayOutputStream();
		FileOutputStream fos=new FileOutputStream("mydog.bin");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(dog);
		fos.close();
		
		FileInputStream fis=new FileInputStream("mydog.bin");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Dog cloneDog=(Dog) ois.readObject();
		System.out.println("Clone: "+cloneDog);
		/*
		ByteArrayInputStream bais=new ByteArrayInputStream(
				baos.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bais);
		Dog cloneDog=(Dog) ois.readObject();
		
		//Dog cloneDog=(Dog) dog.clone();
		dog.setName("Alex");
		owner.setName("Jane");
		//dog.setOwner(owner);
		System.out.println("Clone: "+cloneDog);
		System.out.println("Origin: "+dog);*/
	}

}

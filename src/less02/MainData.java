package less02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainData {

	public static void main(String[] args) {
		Dog dog = new Dog("Susleg", 5);
		// try(DataOutputStream dos=new DataOutputStream(
		// new FileOutputStream("dog.bin"))){
		// dos.writeUTF(dog.getName());
		// dos.writeInt(dog.getAge());
		// System.out.println("Done...");
		// }catch(IOException e){
		//
		// }

		try (DataInputStream dis = new DataInputStream(new FileInputStream("dog.bin"))) {
			Dog cloneDog = new Dog(dis.readUTF(), dis.readInt());
			System.out.println(cloneDog);
			System.out.println("Done...");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

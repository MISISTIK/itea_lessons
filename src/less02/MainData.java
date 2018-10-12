package less02;

import java.io.*;

public class MainData {
    public static void main(String[] args) {
        Dog dog = new Dog("dog",5);
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("dog.bin"))) {
            dos.writeUTF(dog.getName());
            dos.write(dog.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try (DataInputStream dis = new DataInputStream(new FileInputStream("dog.bin"))) {
            Dog cloneDog = new Dog(dis.readUTF(),dis.read());
            System.out.println("Done...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}

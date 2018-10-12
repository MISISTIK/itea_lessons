package less02;

import java.io.*;

public class MainM {
    public static void main(String[] args) throws CloneNotSupportedException {
        Dog dog = new Dog("Susleg",5);
        Owner owner = new Owner("Me");
        dog.setOwner(owner);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();


        try {
            FileOutputStream fos = new FileOutputStream("dog1.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dog);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Dog cloneDog1 = null;

        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            FileInputStream fis = new FileInputStream("dog1.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            cloneDog1 = (Dog) ois.readObject();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Dog cloneDog = (Dog) dog.clone();
        dog.setName("Alex");
        owner.setName("Jane");
        dog.setOwner(owner);

        System.out.println("Clone: " + cloneDog);
        System.out.println("Clone1: " + cloneDog1);

    }
}

package less01;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("myfile.txt", "rw")) {
            byte[] buff = new byte[1024];
            raf.read(buff);
            System.out.println(new String(buff));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

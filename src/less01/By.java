package itea.less01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class By {
    public static void main(String[] args) {

        try {
            Files.deleteIfExists(Paths.get("putty_copy.exe"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("putty.exe");
             FileOutputStream fout = new FileOutputStream("putty_copy.exe")) {

            int c = 0;
            while((c=fis.read()) != -1) {
                fout.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

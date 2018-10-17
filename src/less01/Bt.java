package less01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bt {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("myfile.txt");
             FileWriter fw = new FileWriter("myfile_copy.txt")) {

            int c = 0;
            while ((c=fr.read()) != -1) {
                fw.write(c);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

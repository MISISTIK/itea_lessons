package less01;

import java.io.*;
import java.nio.Buffer;

public class RL {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            br = new BufferedReader(new FileReader("myfile.txt"));
            pw = new PrintWriter(new FileWriter("myfile_rl!.txt"));
            String str = "";
            while ((str=br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

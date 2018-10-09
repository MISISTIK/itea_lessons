package less01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class MySc {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("num.txt"));
            in.useDelimiter(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (Objects.requireNonNull(in).hasNext()) {
            System.out.println(in.next());
        }

    }
}

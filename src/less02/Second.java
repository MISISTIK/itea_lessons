package less02;

import java.io.File;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        File file = new File("C:/Windows");
        Scanner s = new Scanner(System.in);
        String input = "";
        do
        {
            System.out.print("cd ");
            input = s.nextLine();

            File nf = new File(file.getAbsolutePath() + "/" + input);

            if (nf.exists() && nf.isDirectory()) {
                File[] flist = nf.listFiles();
                assert flist != null;
                if (flist.length > 0) {
                    for (File f : flist) {
                        if (f.isDirectory())
                            System.out.println(f.getName());
                    }
                    for (File f : flist) {
                        if (!f.isDirectory())
                            System.out.println(f.getName());
                    }
                }
            }
        } while (!input.equals("exit"));
        s.close();
    }
}

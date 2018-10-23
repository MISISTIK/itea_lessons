package less03;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NIOExample {

    public static void main(String[] args) {
        Path path = Paths.get("C:/Users/Java/eclipse-workspace/AdvO/src/less03/MyClient.java");
        System.out.println(Files.isExecutable(path));
        System.out.println(Files.isReadable(path));
        File file = new File(path.toUri());
        file.mkdir();
        Path toCopy = Paths.get("C:/Users/Java/eclipse-workspace/AdvO/src/MyClient.java");

        try {
            //Files.copy(path, toCopy);
            Files.move(path, toCopy, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

package file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author sskim
 */
public class FilesReadAllBytes {
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("/Users/sskim/dev/java-spring-lab/sample-java/src/main/resources/coin.csv");
        byte[] bytes = Files.readAllBytes(path);
        System.out.println("bytes = " + bytes);

    }
}

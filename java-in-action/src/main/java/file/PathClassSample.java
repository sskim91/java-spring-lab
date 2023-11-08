package file;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author sskim
 */
public class PathClassSample {
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("/Users/sskim/Desktop/홈페이지 비정상 실행.png");
        System.out.println("path = " + path);

        Files.copy(path, new FileOutputStream("/Users/sskim/Downloads/ppp.png"));

    }
}

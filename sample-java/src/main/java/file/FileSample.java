package file;

import java.io.File;
import java.io.IOException;

/**
 * @author sskim
 */
public class FileSample {
    public static void main(String[] args) {

        String path = "/Users/sskim/Documents/test";

        File file = new File(path, "file.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file1 = new File(path, "2020/11/03");
        file1.mkdirs();
    }
}

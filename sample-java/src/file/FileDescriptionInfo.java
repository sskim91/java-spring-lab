package file;

import java.io.File;
import java.util.Arrays;

/**
 * @author sskim
 */
public class FileDescriptionInfo {

    public static void main(String[] args) {

        File file = new File("/Users/sskim/Documents");

        Arrays.stream(file.listFiles()).forEach(i -> {
            if (!i.isHidden() && i.isFile()) {
                System.out.println(i.getName() + "\t\t\t\t\t" + i.length() );
            }
        });

//        File[] files = file.listFiles();
//
//        for (int i = 0; i < files.length; i++) {
//            File file1 = files[i];
//            System.out.println(file1.getName() + "\t\t" + file1.length() );
//        }
    }
}

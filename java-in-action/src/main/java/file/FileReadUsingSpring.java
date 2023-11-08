package file;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * @author sskim
 */
public class FileReadUsingSpring {
    public static void main(String[] args) throws Exception {

        //ResourceUtils
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "test.txt");
        Stream<String> lines = Files.lines(file.toPath());
        lines.forEach(System.out::println);


        //InputStream
        InputStream inputStream = new ClassPathResource("test.txt").getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines()
                .forEach(System.out::println);

        //File
        File file2 = new ClassPathResource("test.txt").getFile();
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file2));
        bufferedReader1.lines()
                .forEach(System.out::println);

    }
}

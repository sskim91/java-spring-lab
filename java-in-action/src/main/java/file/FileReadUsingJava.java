package file;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author sskim
 */
public class FileReadUsingJava {
    public static void main(String[] args) throws Exception {

        URL resource = FileReadUsingJava.class.getClassLoader().getResource("test.txt");
        List<String> strings = Files.readAllLines(Paths.get(resource.toURI()));
        strings.forEach(System.out::println);

        //InputStream
        InputStream inputStream = FileReadUsingJava.class.getClassLoader().getResource("test.txt").openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines()
                .forEach(System.out::println);

        //File로 읽기
        ClassLoader classLoader = FileReadUsingJava.class.getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file));
        bufferedReader1.lines()
                .forEach(System.out::println);

        //Paths 사용
        String path = FileReadUsingJava.class.getClassLoader().getResource("test.txt").getPath();
        Stream<String> lines = Files.lines(Paths.get(path));
        lines.forEach(System.out::println);
    }
}

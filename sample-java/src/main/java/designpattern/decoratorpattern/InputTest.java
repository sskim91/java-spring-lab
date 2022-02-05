package designpattern.decoratorpattern;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sskim on 2022/02/04
 * Github : http://github.com/sskim91
 */
public class InputTest {
    public static void main(String[] args) {
        int c;
        try (InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("src/main/resources/test.txt")))) {

            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

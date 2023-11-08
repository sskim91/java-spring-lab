package file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author sskim
 */
public class CommonsIOSample {
    public static void main(String[] args) throws Exception {

        //URL로 가져온 파일을 로컬에 저장.
        copyURLtoFile();

    }

    private static void copyURLtoFile() throws IOException {
        URL fetchWebsite = new URL("https://theswissbay.ch/pdf/Gentoomen%20Library/Programming/Java/Introduction%20to%20Java%20IO.pdf");
        File file = new File("JavaIo.pdf");
        FileUtils.copyURLToFile(fetchWebsite, file);
    }
}

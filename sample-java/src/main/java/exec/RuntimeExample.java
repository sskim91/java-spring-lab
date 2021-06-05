package exec;

import java.io.File;

/**
 * @author sskim
 */
public class RuntimeExample {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        //실행할 파일 경로
        //C:\Program Files\PuTTY
        String file = "C:" + File.separator + "Program Files" + File.separator + "PuTTY" + File.separator + "putty.exe";

        Process process;

        try {
            process = runtime.exec(file);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

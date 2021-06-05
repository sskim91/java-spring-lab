package annotation;


/**
 * Created by sskim on 2021/06/06
 * Github : http://github.com/sskim91
 */
public class CustomAnnotationSample {
    public static void main(String[] args) {
        Validator checker = new Validator();

        Score score = new Score("sskimsskim", 1, 100, 100, 100);
        try {
            checker.execute(score);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

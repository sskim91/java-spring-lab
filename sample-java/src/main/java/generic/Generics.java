package generic;

/**
 * Created by sskim on 2022/02/02
 * Github : http://github.com/sskim91
 */
public class Generics {

    public static <T extends Number> void print1(T t) {
        System.out.println(t.toString());
    }

    public static void main(String[] args) {
//        Generics.print1("aa");
//        Generics.print1(1);
        Student<String> stringStudent = new Student<>();
    }
}

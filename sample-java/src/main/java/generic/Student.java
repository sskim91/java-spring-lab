package generic;

import java.lang.reflect.Field;

/**
 * Created by sskim on 2022/02/02
 * Github : http://github.com/sskim91
 */
public class Student<T> {
    T value;

    public Student() {
    }

    public Student(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public T setValue(T value) {
        this.value = value;
        return value;
    }

    public T print(T value) {
        System.out.println("value = " + value);
        return value;
    }

    public <V> V toto2(V id) {
        return id;
    }

    public static void main(String[] args) throws Exception {

        System.out.println("className = " + Student.class.getName());
        Field value1 = Student.class.getDeclaredField("value");
        System.out.println("value1 = " + value1);
        System.out.println(value1.getType());
    }
}

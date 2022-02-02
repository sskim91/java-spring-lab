package generic;

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
}

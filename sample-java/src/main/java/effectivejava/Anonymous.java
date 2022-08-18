package effectivejava;

/**
 * @author sskim
 */
public class Anonymous {
    public static void main(String[] args) {


        Comparable comparable = new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

        Person anonymous = new Person() {
            @Override
            public String name() {
                return super.name();
            }
        };

        Person person = new Person();

        System.out.println(comparable.getClass());
        System.out.println(person.getClass());
        System.out.println(anonymous.getClass());

    }

    static class Person{
        private String name;

        public String name() {
            return name;
        }
    }
}

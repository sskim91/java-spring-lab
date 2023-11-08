package practicaljavaexample;

public class InnerClassTest {
    public static void main(String[] args) {

        InnerClassTest innerClassTest = new InnerClassTest();

        innerClassTest.parameterInterface(new FilterInterface() {
            @Override
            public void test1() {

            }

            @Override
            public void test2() {

            }
        });
    }

    public void parameterInterface(FilterInterface filterInterface) {

    }
}

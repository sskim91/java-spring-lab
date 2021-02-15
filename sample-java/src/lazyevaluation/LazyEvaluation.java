package lazyevaluation;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author sskim
 */
public class LazyEvaluation {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        /**
         * 기존 자바
         * getValueUsingMethodResult 를 호출하기 위해서 두번째 인자 메서드인 getExpensiveValue가 먼저 실행된다.
         */
//        getValueUsingMethodResult(true,getExpensiveValue());
//        getValueUsingMethodResult(false,getExpensiveValue());
//        getValueUsingMethodResult(false,getExpensiveValue());

        /**
         * JAVA8 이후 Supplier를 활용해서 lazy evaluation이 가능하다.
         * getValueUsingSupplier가 먼저 실행되고 조건문이 만족할 때만 get() 메소드를 실행하기때문에
         * Supplier의 get() 메소드가 호출될때만 getExpensiveValue가 실행이 된다.
         */
        getValueUsingSupplier(true, () -> getExpensiveValue());
        getValueUsingSupplier(false, () -> getExpensiveValue());
        getValueUsingSupplier(false, () -> getExpensiveValue());

        System.out.println("passed Time: "+ (System.currentTimeMillis()-startTime)/1000+"sec" );

    }

    public static void getValueUsingMethodResult(boolean valid, String value) {
        if (valid) {
            System.out.println("Success: The value is " + value);
        } else {
            System.out.println("Failed: Invalid action");
        }
    }

    public static void getValueUsingSupplier(boolean valid, Supplier<String> value) {
        if (valid) {
            System.out.println("Success: The value is " + value.get());
        } else {
            System.out.println("Failed: Invalid action");
        }
    }

    public static String getExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello World";
    }

}

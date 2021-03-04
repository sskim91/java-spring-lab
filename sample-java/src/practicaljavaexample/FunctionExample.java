package practicaljavaexample;

import java.util.function.Function;

public class FunctionExample {

    public static int executeFunction(String context, Function<String, Integer> function) {
        return function.apply(context);
    }

    public static void main(String[] args) {
        executeFunction("Hello! Welcome to Java World",
                (String context) -> context.length());
    }
}

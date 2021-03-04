package practicaljavaexample;

import java.util.function.Supplier;

public class SupplierExample {

    public static String executeSupplier(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {

        String version = "java upgrade book, version 0.1 BETA";
        System.out.println(executeSupplier(() -> {
            return version;
        }));
    }
}

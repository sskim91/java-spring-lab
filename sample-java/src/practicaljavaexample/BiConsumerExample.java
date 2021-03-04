package practicaljavaexample;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void executeBiConsumer(String param1, String param2, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(param1, param2);
    }

    public static void main(String[] args) {

        BiConsumerExample.executeBiConsumer("Hello!", "World!", (String a, String b) -> {
            System.out.println(a);
            System.out.println(b);
        });
    }
}

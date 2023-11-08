package practicaljavaexample;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void executeConsumer(List<String> nameList, Consumer<String> consumer) {
        for (String name : nameList) {
            consumer.accept(name);
        }
    }

    public static void main(String[] args) {

        List<String> nameList = List.of("정수빈", "김재호", "오재원", "이영하");

        executeConsumer(nameList, (String name) -> System.out.println(name));

    }
}

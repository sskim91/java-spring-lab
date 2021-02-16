package stream;

import java.util.stream.IntStream;

/**
 * @author sskim
 */
public class IntStreamSample {
    public static void main(String[] args) {

        System.out.println("range");
        IntStream.range(0, 5)
                .forEach(System.out::println);

        System.out.println("=========");

        System.out.println("rangeClosed");
        IntStream.rangeClosed(0, 5)
                .forEach(System.out::println);

        //짝수의 개수 구하기
        long evenCount = IntStream.range(0, 100)
                .filter(i -> i % 2 == 0)
                .count();
        System.out.println("짝수 개수 = " + evenCount);
    }
}


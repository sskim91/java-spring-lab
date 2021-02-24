package optionalTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author sskim
 */
public class OptionalTest {

    @Test
    @DisplayName("orElse와 orElseGet의 차이")
    void javaOptionalCheck() throws Exception{
        String checkName = "myname";
        String result = Optional.ofNullable(checkName).orElse(defaultName());
        System.out.println("first result is = " + result);

        result = Optional.ofNullable(checkName).orElseGet(this::defaultName);
        System.out.println("second result is = " + result);
    }

    @Test
    @DisplayName("값이 null일때")
    void javaOptionalNullCheck() throws Exception{
        String checkName = null;
        String result = Optional.ofNullable(checkName).orElse(defaultName());
        System.out.println("first result is = " + result);

        //lazy evaluation 과 관련있는 이야기인것 같음.
        //null이 아닐 경우에만 Supplier의 get()이 실행된다.
        result = Optional.ofNullable(checkName).orElseGet(this::defaultName);
        System.out.println("second result is = " + result);
    }

    private String defaultName() {
        System.out.println("return Default Name");
        return "default name";
    }
}

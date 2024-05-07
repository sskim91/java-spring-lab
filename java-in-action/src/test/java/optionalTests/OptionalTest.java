package optionalTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("Optional ofNullable")
    void optionalNullableTest() throws Exception {
        //given
        String value = "example";

        //when
        final String result = Optional.ofNullable(value)
                .map(v -> {
                    if("example".equals(v)) {
                        return null;
                    }
                    return v.toUpperCase();
                })
                .orElseGet(() -> "Default Value");

        //then
        assertThat(result).isEqualTo("Default Value");

    }

    private String makeUpper(String str) {
        final String upperCase = str.toUpperCase();
        return upperCase.equals("HELLO") ? null: upperCase;
    }

    private String defaultName() {
        System.out.println("return Default Name");
        return "default name";
    }
}

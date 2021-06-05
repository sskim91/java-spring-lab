package exact;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * @author sskim
 */
public class ExactTests {

    @Test
    @DisplayName("더하기")
    void addExactTest() throws Exception {
        int a = 1000;
        int b = 2000;
        assertThat(Math.addExact(a, b)).isEqualTo(3000);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.addExact(1, Integer.MAX_VALUE))
                .withMessageMatching("integer overflow");

        long x = 10L;
        long y = 20L;
        assertThat(Math.addExact(x, y)).isEqualTo(30L);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.addExact(1, Long.MAX_VALUE))
                .withMessageMatching("long overflow");
    }

    @Test
    @DisplayName("빼기")
    void subtractExactTest() throws Exception {
        int a = 1000;
        int b = 2000;
        assertThat(Math.subtractExact(a, b)).isEqualTo(-1000);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.subtractExact(Integer.MAX_VALUE, -1))
                .withMessageMatching("integer overflow");

        long x = 10L;
        long y = 20L;
        assertThat(Math.subtractExact(x, y)).isEqualTo(-10L);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.subtractExact(Long.MAX_VALUE, -1))
                .withMessageMatching("long overflow");
    }

    @Test
    @DisplayName("곱하기")
    void multiplyExactTest() throws Exception {
        int a = 1000;
        int b = 2000;
        assertThat(Math.multiplyExact(a, b)).isEqualTo(2_000_000);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.multiplyExact(Integer.MAX_VALUE, 2))
                .withMessageMatching("integer overflow");

        long x = 10L;
        long y = 20L;
        assertThat(Math.multiplyExact(x, y)).isEqualTo(200L);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.multiplyExact(Long.MAX_VALUE, 2))
                .withMessageMatching("long overflow");
    }

    @Test
    @DisplayName("인수에 1증가 값")
    void incrementExactTest() throws Exception {

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.incrementExact(Integer.MAX_VALUE))
                .withMessageMatching("integer overflow");

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.incrementExact(Long.MAX_VALUE))
                .withMessageMatching("long overflow");
    }

    @Test
    @DisplayName("인수에 1마이너스 값")
    void decrementExact() throws Exception {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.decrementExact(Integer.MIN_VALUE))
                .withMessageMatching("integer overflow");

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.decrementExact(Long.MIN_VALUE))
                .withMessageMatching("long overflow");
    }

    @Test
    @DisplayName("부호를 변경")
    void negateExactTest() throws Exception{
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.negateExact(Integer.MIN_VALUE))
                .withMessageMatching("integer overflow");

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.negateExact(Long.MIN_VALUE))
                .withMessageMatching("long overflow");
    }

    @Test
    @DisplayName("long을 int로 변환")
    void toIntExactTest() throws Exception{

        assertThat(Math.toIntExact(20L)).isEqualTo(20);

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Math.toIntExact(Long.MAX_VALUE))
                .withMessageMatching("integer overflow");
    }
}

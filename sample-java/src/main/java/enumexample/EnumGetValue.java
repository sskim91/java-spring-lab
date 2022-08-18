package enumexample;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * @author sskim
 */
public class EnumGetValue {
    public static void main(String[] args) {

        String mobile = Arrays.stream(PaymentOption.values())
                .map(PaymentOption::name)
                .findFirst()
                .orElseThrow();
        System.out.println("mobile = " + mobile);

        String power_on = AccessType.find("POWER_ON");
        System.out.println("power_on = " + power_on);

    }

    @Getter
    @AllArgsConstructor
    public enum AccessType {

        POWER_ON("1"),
        POWER_OFF("2"),
        LOGIN("3"),
        LOGOUT("4");

        private final String code;

        public static String find(String type) {
            return Arrays.stream(AccessType.values())
                    .filter(i -> i.name().equals(type))
                    .map(AccessType::getCode)
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
        }

        public static List<String> find2(String type) {
            return Arrays.stream(AccessType.values())
                    .map(Enum::name)
                    .filter(code -> code.equals(type))
                    .collect(Collectors.toList());
        }
    }
}

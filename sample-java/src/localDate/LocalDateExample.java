package localDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author sskim
 */
public class LocalDateExample {

    public static void main(String[] args) {
        System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}

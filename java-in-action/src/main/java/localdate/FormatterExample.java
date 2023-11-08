package localdate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author sskim
 */
public class FormatterExample {
    public static void main(String[] args) {

        LocalDate yyyyMMdd1 = LocalDate.parse("20181109", DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println("yyyyMMdd1 = " + yyyyMMdd1);

        String format = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);

    }
}

package localDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author sskim
 */
public class LocalDateExample {

    public static void main(String[] args) {
        System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));

        BetweenDays();
    }

    /**
     * 날짜 비교
     */
    private static void BetweenDays() {
        List<String> filterDays = new ArrayList<>();

        LocalDate st = LocalDate.parse("2021-02-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate ed = LocalDate.parse("2021-02-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        long daysBetween = DAYS.between(st, ed);
        System.out.println("daysBetween = " + daysBetween);

        IntStream.rangeClosed(0, Math.toIntExact(daysBetween)).forEach(intValue -> {
            filterDays.add(ed.minusDays(intValue).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        });

//        if (daysBetween < 1) {
//            filterDays.add(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
//        } else {
//            IntStream.range(0, Math.toIntExact(daysBetween)).forEach(intValue -> {
//                filterDays.add(ed.minusDays(intValue).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
//            });
//        }


        filterDays.stream().forEach(System.out::println);
    }
}

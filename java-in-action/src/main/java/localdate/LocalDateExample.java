package localdate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.IntStream;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author sskim
 */
public class LocalDateExample {

    public static void main(String[] args) {
//        System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));

//        printAllLocalDate();
//        System.out.println("=========================================");
//        printAllLocalTime();
//        System.out.println("=========================================");
        printAllLocalDateTime();
//        System.out.println("=========================================");
//        printAllZonedDateTime();
//        printAllInstant();

//        BetweenDays();
        String hh24m = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("HHmm"));
        System.out.println("hh24m = " + hh24m);
        LocalDateTime dt = LocalDateTime.now();
        String hHmm = dt.withMinute((dt.getMinute() / 10) * 10).format(DateTimeFormatter.ofPattern("HHmm"));
        System.out.println("hHmm = " + hHmm);
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

    private static void printAllLocalDate() {
        LocalDate nowDate = LocalDate.now();
        LocalDate targetDate = LocalDate.of(2021, 3, 1);

        System.out.println("현재날짜 가져오기 = " + nowDate);
        System.out.println("targetDate = " + targetDate);

        System.out.println("현재월의 날짜를 얻어옴: " + targetDate.getDayOfMonth());
        System.out.println("년도를 가져옴: " + targetDate.getYear());
        System.out.println("월을 숫자로 받아옴: " + targetDate.getMonthValue());
        System.out.println("월을 가져옴 (Month 열거값): " + targetDate.getMonth());
        System.out.println("일자를 가져옴 (DayOfWeek 열거값): " + targetDate.getDayOfWeek());
        System.out.println("일년의 몇 번째 일?: " + targetDate.getDayOfYear());
        System.out.println("윤년여부: " + targetDate.isLeapYear());  //2021년은 윤년이 아니다.

        System.out.println("년도 더하기: " + targetDate.plusYears(1));
        System.out.println("월 더하기: " + targetDate.plusMonths(1));
        System.out.println("주 더하기: " + targetDate.plusWeeks(1));
        System.out.println("일 더하기: " + targetDate.plusDays(1));

    }

    private static void printAllLocalTime() {
        LocalTime nowTime = LocalTime.now();
        LocalTime targetTime = LocalTime.of(12, 35, 33, 9999);

        System.out.println("현재시간 가져오기: " + nowTime);
        System.out.println("targetTime = " + targetTime);

        System.out.println("시간: " + targetTime.getHour());
        System.out.println("분: " + targetTime.getMinute());
        System.out.println("초: " + targetTime.getSecond());
        System.out.println("나노초: " + targetTime.getNano());

        System.out.println("시간 더하기: " + targetTime.plusHours(1));
        System.out.println("분 더하기: " + targetTime.plusMinutes(1));
        System.out.println("초 더하기: " + targetTime.plusSeconds(1));
        System.out.println("나노 초 더하기: " + targetTime.plusNanos(1));

        System.out.println("시간 빼기: " + targetTime.minusHours(1));
        System.out.println("분 빼기: " + targetTime.minusMinutes(1));
        System.out.println("초 빼기: " + targetTime.minusSeconds(1));
        System.out.println("나노 초 빼기: " + targetTime.minusNanos(1));

    }

    private static void printAllLocalDateTime() {

        //LocalDate와 LocalTime을 합친 LocalDateTime이 있다.
        //날짜와 시간정보가 모두 필요할때 사용한다.
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        LocalDateTime targetLocalDateTime = LocalDateTime.of(2021, 3, 1, 12, 35);

        System.out.println("nowLocalDateTime = " + nowLocalDateTime);
        System.out.println("기존 LocalDate와 LocalTime이 제공하는 메서드를 모두 사용할 수 있다.");

        //LocalDateTime을 LocalDate 또는 LocalTime으로 변환 하는 방법
        LocalDate localDate = targetLocalDateTime.toLocalDate();
        LocalTime localTime = targetLocalDateTime.toLocalTime();

        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);
    }


    private static void printAllZonedDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime = " + zonedDateTime);
        ZonedDateTime SeoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("SeoulDateTime = " + SeoulDateTime);
        String jst = ZoneId.SHORT_IDS.get("JST");
        System.out.println("jst = " + jst);

        ZonedDateTime parisTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("parisTime = " + parisTime);

        ZoneId romeZone = ZoneId.of("Europe/Rome");
        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

        System.out.println("zdt1 = " + zdt1);
        System.out.println("zdt2 = " + zdt2);
        System.out.println("zdt3 = " + zdt3);

        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println(zoneId); //Asia/Seoul

    }

    private static void printAllInstant() {
        Instant instant1 = Instant.now();
        Instant instant2 = Instant.now();

        if (instant1.isBefore(instant2)) {
            System.out.println("instant1이 빠릅니다.");
        } else if (instant1.isAfter(instant2)) {
            System.out.println("instant1이 늦습니다.");
        } else {
            System.out.println("동일한 시간입니다.");
        }
        System.out.println("차이(nanos): " + instant1.until(instant2, ChronoUnit.NANOS));
    }
}

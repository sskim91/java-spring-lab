package localdate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author sskim
 */
public class JavaTimeExample {
    public static void main(String[] args) {
//        PeriodPrint();
//        DurationPrint();
//        useUntilStaticMethod();
//        useChronoUnitBetween();
//        parsingDate();
//        formatDate();
//        modifyDate();
        compareDate();
    }

    private static void compareDate() {
        LocalDate startDate = LocalDate.of(2021, 3, 25);
        LocalDate endDate = LocalDate.of(2021, 4, 25);

        //startDate가 endDate보다 이전인지 비교
        startDate.isBefore(endDate);
        //startDate가 endDate와 같은지 비교
        startDate.isEqual(endDate);
        //startDate가 endDate보다 이후인지 비교
        startDate.isAfter(endDate);
    }

    private static void modifyDate() {
        LocalTime localTime = LocalTime.of(1, 15, 30)
                .withHour(1)    //시간 변경
                .withMinute(10) //분 변경
                .withSecond(25) //초 변경
                .withNano(100); //나노초 변경
        System.out.println("localTime = " + localTime);

        LocalDate localDate = LocalDate.of(2021, 3, 25)
                .withYear(2020) //년 변경
                .withMonth(12)  //월 변경
                .withDayOfMonth(25) //월의 일 변경
                .withDayOfYear(11)  //년의 일 변경
                .with(TemporalAdjusters.firstDayOfMonth()); //상대 변경
        System.out.println("localDate = " + localDate);
    }

    private static void formatDate() {
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("format = " + format);

        String format1 = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("format1 = " + format1);
    }

    private static void parsingDate() {
        LocalDate parse = LocalDate.parse("2021-03-25");
        System.out.println("parse = " + parse);

        LocalDate parse1 = LocalDate.parse("2021-04-25", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("parse1 = " + parse1);

        LocalDate parse2 = LocalDate.parse("2021/04/25", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("parse2 = " + parse2);
    }

    private static void useChronoUnitBetween() {
        LocalDateTime startDateTime = LocalDateTime.of(2021, 3, 15, 15, 30);
        LocalDateTime endDateTime = LocalDateTime.of(2021, 4, 30, 15, 30);

        long remainYear = ChronoUnit.YEARS.between(startDateTime, endDateTime);
        long remainMonth = ChronoUnit.MONTHS.between(startDateTime, endDateTime);
        long remainDay = ChronoUnit.DAYS.between(startDateTime, endDateTime);
        long remainHour = ChronoUnit.HOURS.between(startDateTime, endDateTime);
        long remainSecond = ChronoUnit.SECONDS.between(startDateTime, endDateTime);

        System.out.println("remainYear = " + remainYear);
        System.out.println("remainMonth = " + remainMonth);
        System.out.println("remainDay = " + remainDay);
        System.out.println("remainHour = " + remainHour);
        System.out.println("remainSecond = " + remainSecond);

    }

    private static void useUntilStaticMethod() {
        LocalDate startDate = LocalDate.of(2021, 3, 11);
        LocalDate endDate = LocalDate.of(2021, 4, 15);
        Period period = startDate.until(endDate);
        System.out.println(period.getYears());  //0
        System.out.println(period.getMonths()); //1
        System.out.println(period.getDays());   //4

        LocalTime startTime = LocalTime.of(15, 42);
        LocalTime endTime = LocalTime.of(16, 42);
        long until = startTime.until(endTime, ChronoUnit.HOURS);
        System.out.println(until);  //1
    }

    private static void DurationPrint() {
        LocalTime startTime = LocalTime.of(15, 42);
        LocalTime endTime = LocalTime.of(16, 42);

        Duration between = Duration.between(startTime, endTime);
        System.out.println("초 간격 = " + between.getSeconds());
        System.out.println("나노 초 간격 = " + between.getNano());
        System.out.println("간격이 음수인지 확인 = " + between.isNegative());
        System.out.println("간격이 0인지 확인 = " + between.isZero());
    }

    private static void PeriodPrint() {
        LocalDate startDate = LocalDate.of(2021, 3, 11);
        LocalDate endDate = LocalDate.of(2021, 4, 15);

        Period between = Period.between(startDate, endDate);
        System.out.println("년간격 = " + between.getYears());
        System.out.println("월간격 = " + between.getMonths());
        System.out.println("일자간격 = " + between.getDays());
        System.out.println("between.getUnits() = " + between.getUnits());
        System.out.println("between.get(ChronoUnit.DAYS) = " + between.get(ChronoUnit.DAYS));
    }
}

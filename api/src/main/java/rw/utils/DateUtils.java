package rw.utils;


import java.time.*;
import java.util.Date;

import static java.time.DayOfWeek.*;

public final class DateUtils {

    public static long daysBetween(LocalDate first, LocalDate second) {
        return Duration.between(first.atTime(0, 0), second.atTime(0, 0)).toDays();
    }

    /**
     * We cant do a submission on the weekend or friday
     */
    public static boolean isSubmissionDay(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek != SATURDAY && dayOfWeek != SUNDAY && dayOfWeek != FRIDAY;
    }

    public static Date of(int year, Month month, int days) {
        return toDate(LocalDate.of(year, month, days));
    }


    /**
     * Support old java format
     *
     */
    private static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }


}

package rw.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void shouldCalculateDaysBetween() {
        LocalDate now = LocalDate.now();
        LocalDate then = LocalDate.now().plusDays(5);
        Assert.assertEquals(5, DateUtils.daysBetween(now, then));
    }

    @Test
    public void shouldDetectSubmissionDays() {
        LocalDate friday = LocalDate.of(2016, 2, 19);
        LocalDate saturday = friday.plusDays(1);
        LocalDate sunday = saturday.plusDays(1);
        Assert.assertFalse(DateUtils.isSubmissionDay(friday));
        Assert.assertFalse(DateUtils.isSubmissionDay(saturday));
        Assert.assertFalse(DateUtils.isSubmissionDay(sunday));
    }

}
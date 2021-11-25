package com.kapcb.framework.common.util;

import lombok.experimental.UtilityClass;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

/**
 * <a>Title: DateUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: DateUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/8 20:47
 */
@UtilityClass
public class DateUtil {

    public static String format(Date date, String pattern) {
        return new DateTime(date).toString(pattern);
    }

    public static String format(LocalDate localDate, String pattern) {
        return new DateTime(localDate).toString(pattern);
    }

    public static String format(LocalDateTime localDateTime, String pattern) {
        return new DateTime(localDateTime).toString(pattern);
    }

    public static DateTime parseDateTime(String dateTime, String pattern, Locale locale) {
        return DateTimeFormat.forPattern(pattern).withLocale(locale).parseDateTime(dateTime);
    }

}

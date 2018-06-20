package datetime;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tayfuno on 29/03/16.
 */
public class DateTimeTest {

    public static final String DATE_FORMAT_PATTERN = "YYYY-MM-DD'T'HH:mm:ssZ";

    @Test
    public void testYear() {
        SimpleDateFormat f = new SimpleDateFormat(DATE_FORMAT_PATTERN);

        try {
            Date d = f.parse("1985-01-30T15:00:00+0200");
            System.out.println(d);
            assertTrue(d.after(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConvertTimestampValueOf() {
        String DATE_FORMAT_PATTERN = "yyyy-MM-dd hh:mm:ss";

        SimpleDateFormat f = new SimpleDateFormat(DATE_FORMAT_PATTERN);

        Date date = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
        System.out.println(date);

        String st = f.format(date);

        System.out.println(st);

        Timestamp tp = Timestamp.valueOf(st);

        System.out.println(tp);
        System.out.println(tp.toString());

    }

    @Test
    public void testTimestampValueOf() {
        String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

        Timestamp tp = Timestamp.valueOf("2017-01-01 11:00:00+00:00");

        System.out.println(tp);
        System.out.println(tp.getTimezoneOffset());

        Calendar calendar =  Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(tp.getTime());

        System.out.println(new Date(tp.getTime()));

    }


@Test
public void testCalendar() {

    Calendar cal = Calendar.getInstance();
    Calendar utcCal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

    int utcHour = utcCal.get(Calendar.HOUR_OF_DAY);
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    assertTrue( utcHour< hour);

    Date utcDate = utcCal.getTime();
    Date date = cal.getTime();

    assertEquals(utcDate, date);



}

}

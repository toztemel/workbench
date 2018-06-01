package calendar;

import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

import static junit.framework.Assert.assertEquals;

/**
 * Created by tayfuno on 25/10/16.
 */
public class CalendarTest {

    long INPUT_IN_MILLIS = 1483275600000L; // This is 'Sun, 01 Jan 2017 13:00:00 GMT'

    @Test
    public void set_time_before_zone() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(INPUT_IN_MILLIS);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        assertEquals(13, calendar.get(Calendar.HOUR_OF_DAY));
    }


    @Test
    public void set_zone_before_time() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(INPUT_IN_MILLIS);

        assertEquals(13, calendar.get(Calendar.HOUR_OF_DAY));
    }
}

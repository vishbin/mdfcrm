package mdf.utils;import java.text.ParseException;import java.text.SimpleDateFormat;import java.util.Calendar;import java.util.Date;import java.util.GregorianCalendar;/**
 * Class declaration
 *
 * This utility class for formatting dates.
 *
 * @author Dataware Solutions Inc
 * @version
 */
public final class DateUtil extends Object
{	public static final long MILLISECONDS_PER_DAY = 1000*60*60*24;
    public static String formatDate(Date dt, String format)
    {
        if (dt != null)
        {
            SimpleDateFormat dtFormat = new SimpleDateFormat(format);
            return dtFormat.format(dt);
        }
        else
        {
            return "";
        }
    }
    public static Date parseDate(String dt, String format) {
        if (dt != null) {
            try {
                SimpleDateFormat dtFormat = new SimpleDateFormat(format);
                return dtFormat.parse(dt);
            } catch (ParseException ex) {
                System.out.println("Exception on parseDate " + ex);
                return null;
            }
        } else {
            return null;
        }
    }
    public static int diffDays(Date start, Date end) {        if (start != null && end != null) {            try {            	return Math.ceil((end.getTime() - start.getTime())/MILLISECONDS_PER_DAY);            } catch (ParseException ex) {                System.out.println("Exception on DiffDays " + ex);                return 0;            }        } else {            return 0;        }    }    public static String getPrevBusinessDate()
    {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SATURDAY)
            calendar.add(Calendar.DATE, -1);
        else if (dayOfWeek == Calendar.SUNDAY)
            calendar.add(Calendar.DATE, -2);
        return DateUtil.formatDate(calendar.getTime(), "MM/dd/yyyy");
    }
}
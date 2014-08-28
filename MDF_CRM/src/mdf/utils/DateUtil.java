package mdf.utils;import java.sql.Timestamp;import java.text.ParseException;import java.text.SimpleDateFormat;import java.util.Calendar;import java.util.Date;import java.util.GregorianCalendar;/**
 * Class declaration
 *
 * This utility class for formatting dates.
 *
 * @version
 */
public final class DateUtil extends Object
{
	public static final long MILLISECONDS_PER_DAY = 1000*60*60*24;    public static String formatDate(Date dt, String format)
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
    public static String formatDate(Timestamp ts, String format)    {        if (ts != null)        {            SimpleDateFormat dtFormat = new SimpleDateFormat(format);            return dtFormat.format(ts);        }        else        {            return "";        }    }    public static Date parseDate(String dt, String format) {
        if (dt != null && !dt.equals("")) {
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
    public static java.sql.Date parseSQLDate(String dt, String format) {        if (dt != null && !dt.equals("")) {            try {                SimpleDateFormat dtFormat = new SimpleDateFormat(format);                return new java.sql.Date(dtFormat.parse(dt).getTime());            } catch (ParseException ex) {                System.out.println("Exception on parseDate " + ex);                return null;            }        } else {            return null;        }    }    public static java.sql.Timestamp parseSQLTimestamp(String dt, String format) {        if (dt != null && !dt.equals("")) {            try {                SimpleDateFormat dtFormat = new SimpleDateFormat(format);                return new java.sql.Timestamp(dtFormat.parse(dt).getTime());            } catch (ParseException ex) {                System.out.println("Exception on parseDate " + ex);                return null;            }        } else {            return null;        }    }    public static int diffDays(Date start, Date end) {        if (start != null && end != null) {            try {            	return Double.valueOf(Math.ceil( ((end.getTime()-start.getTime())/MILLISECONDS_PER_DAY) )).intValue();            } catch (Exception ex) {                System.out.println("Exception on DiffDays " + ex);                return 0;            }        } else {            return 0;        }    }    public static String getPrevBusinessDate()
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
    }    public static String getPrevBusinessDateinyyyymmdd()    {        Calendar calendar = new GregorianCalendar();        calendar.setTime(new Date());        calendar.add(Calendar.DATE, -1);        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);        if (dayOfWeek == Calendar.SATURDAY)            calendar.add(Calendar.DATE, -1);        else if (dayOfWeek == Calendar.SUNDAY)            calendar.add(Calendar.DATE, -2);        return DateUtil.formatDate(calendar.getTime(), "yyyy-MM-dd");    }    public static String getDate3BussDaysBeforeToday()    {        Calendar calendar = new GregorianCalendar();        calendar.setTime(new Date());        calendar.add(Calendar.DATE, -3);        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);        if (dayOfWeek == Calendar.SATURDAY)            calendar.add(Calendar.DATE, -1);        else if (dayOfWeek == Calendar.SUNDAY)            calendar.add(Calendar.DATE, -2);        return DateUtil.formatDate(calendar.getTime(), "yyyy-MM-dd");    }
}
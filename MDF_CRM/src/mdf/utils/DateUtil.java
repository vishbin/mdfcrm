package mdf.utils;
 * Class declaration
 *
 * This utility class for formatting dates.
 *
 * @version
 */
public final class DateUtil extends Object
{
	public static final long MILLISECONDS_PER_DAY = 1000*60*60*24;
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
    public static String formatDate(Timestamp ts, String format)
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
    public static java.sql.Date parseSQLDate(String dt, String format) {
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
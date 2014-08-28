//*======================================================================*/
/*   |       Copyright (c) 2004 Allstate Insurance Company          |   */
/*   |                Confidential and Proprietary                  |   */
/*   +==============================================================+   */
/*                                                                      */
/* MODULE:      DateUtil.java                                       */
/*                                                                      */
/*======================================================================*/

/*======================================================================*/
/*                          Package Definition                          */
/*======================================================================*/
package mdf.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/*======================================================================*/
/*                               Imports                                */
/*======================================================================*/
/*==============================================================*/
/* Generated Imports                                            */
/*==============================================================*/
/*======================================================*/
/* Java Platform Core APIs                              */
/*======================================================*/

/*======================================================*/
/* Third-Party Classes                                  */
/*======================================================*/

/*======================================================*/
/* Allstate Classes                                     */
/*======================================================*/

/*==============================================================*/
/* Custom Imports                                               */
/*==============================================================*/

/*======================================================================*/
/*                  Class Definition / Implementation                   */
/*======================================================================*/

/*======================================================================*/
/* CLASS:       DateUtil                                            */
/**
 * Object Model representation of DateUtil aggregate
 * as designed from Acord specification.
 * @see com.allcorp.premium.objectmodel.ModelObject
 */
/*
 * Change History:

 */
/*======================================================================*/
public class Dateutils {


	/*==============================================================*/
	/*==================================================================*/
    /*===========================            ===========================*/
    /*=========================== Attributes ===========================*/
    /*===========================            ===========================*/
    /*==================================================================*/

    /*==================================================================*/
    /* Protected Attributes                                             */
    /*==================================================================*/

    /*==================================================================*/
    /* Private Attributes                                               */
    /*==================================================================*/

    /*==================================================================*/
    /* Class Attributes                                                 */
    /*==================================================================*/
        /*==============================================================*/
        /* Constants                                                    */
        /*==============================================================*/
                /*======================================================*/
                /* ATTRIBUTE:                                           */
                /*                                                      */
                /**
                 *
                 */
                /*======================================================*/
   		private static final String FIRST_DAY = "01";
        /*==============================================================*/
        /* Variables                                                    */
        /*==============================================================*/
                /*======================================================*/
                /* ATTRIBUTE:                                           */
                /*                                                      */
                /**
                 *
                 */
                /*======================================================*/

    /*==================================================================*/
    /*===========================            ===========================*/
    /*=========================== Operations ===========================*/
    /*===========================            ===========================*/
    /*==================================================================*/

	/*==============================================================*/
	/* OPERATION: getStringFormatYYYYMMddWithHyphens                                                  */
	/*                                                              */
	/**
	 *
	 * @param aDate
	 * @return
	 *
	 */
	/*==================================================================*/
    public static String getStringFormatYYYYMMddWithHyphens(Date aDate){
    	SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");

    	if (aDate != null) {
	    	String myFormattedDate = myFormatter.format(aDate);
    		return myFormattedDate;
    	}
   		return null;
    }

        /*====================================================================*/
        /* OPERATION:  getStringFormatddMMYYYYWithSlashes                     */
        /*                                                                    */
        /**
         *
         * This method formats a Data object into a Date String (using the
         * dd/MM/yyyy format).
         *
         * @param aDate:Date - the Date object to be formatted into a time string
         *
         * @return String - the formated date string (dd/MM/yyyy)
         *
         */
        /*====================================================================*/
    public static String getStringFormatddMMYYYYWithSlashes(Date aDate) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("dd/MM/yyyy");

        if (aDate != null) {
            String myFormattedDate = myFormatter.format(aDate);
            return myFormattedDate;
        }
        return null;
    }
    /*==============================================================*/
	/* OPERATION: getDateFormatyyyyMMddWithHyphens                                                  */
	/*                                                              */
	/**
	 *
	 * @param aDateString
	 * @return
	 *
	 */
	/*==============================================================*/
	public static Date getDateFormatyyyyMMddWithHyphens(String aDateString) {
		Calendar myCalendar  = new GregorianCalendar();
		myCalendar.set(Calendar.YEAR, Integer.parseInt(aDateString.substring (0, 4)));
		myCalendar.set(Calendar.MONTH, Integer.parseInt(aDateString.substring (5, 7))-1);
		myCalendar.set(Calendar.DATE, Integer.parseInt(aDateString.substring (8, 10)));
		return (myCalendar.getTime());
    }
	/*==============================================================*/
	/* OPERATION: getStringFormatYYYYMMddWithoutHyphens                                                  */
	/*                                                              */
	/**
	 *
	 * @param aDate
	 * @return
	 *
	 */
	/*==================================================================*/
	public static String getStringFormatYYYYMMddWithoutHyphens(Date aDate){
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMdd");

		if (aDate != null) {
			String myFormattedDate = myFormatter.format(aDate);
			return myFormattedDate;
		}
		return null;
	}

	/*==============================================================*/
	/* OPERATION: getStringFormatMMYYWithoutHyphens                                                  */
	/*                                                              */
	/**
	 *
	 * @param aDate
	 * @return tring
	 *
	 */
	/*==================================================================*/
	public static String getStringFormatMMYYWithoutHyphens(Date aDate){
		SimpleDateFormat myFormatter = new SimpleDateFormat("MMyy");

		if (aDate != null) {
			String myFormattedDate = myFormatter.format(aDate);
			return myFormattedDate;
		}
		return null;
	}

	/*==============================================================*/
	/* OPERATION: getCurrentDateString()                            */
	/*                                                              */
	/**
	 *
	 * @param aDate
	 * @return
	 *
	 */
	/*==================================================================*/
	public static String getCurrentDateString() {
	  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	  Date currentDate = new Date(System.currentTimeMillis());
	  String myFormattedDate = myFormatter.format(currentDate);
	  return myFormattedDate;

	 }
	/*==============================================================*/
	/* OPERATION: getStringACORDFormat()                                                  */
	/*                                                              */
	/**
	 *
	 * @param aDate
	 * @return
	 *
	 */
	/*==================================================================*/
	public static String getStringAcordFormat() {
	  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
	  int currentOffset = myFormatter.getTimeZone().getRawOffset();
	  long diff = currentOffset+18000000;
	  Date currentDate = new Date(System.currentTimeMillis()-diff);
	  String myFormattedDate = myFormatter.format(currentDate);
	  return myFormattedDate;

	 }
	/*==============================================================*/
	/* OPERATION: getStringACORDFormat()                                                  */
	/*                                                              */
	/**
	 *
	 * @param aDate
	 * @return
	 *
	 */
	/*==================================================================*/
	public static String getCurrentDateAndTimeFormat() {
	  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm z");
	  Date currentDate = new Date( System.currentTimeMillis() );
	  String myFormattedDate = myFormatter.format(currentDate);
	  return myFormattedDate;

	 }
	/*==============================================================*/
	/* OPERATION: isValidObjectModelDate                                                  */
	/*                                                              */
	/**
	 *
	 * @param aDate
	 * @return
	 *
	 */
	/*==============================================================*/
	public static boolean isValidObjectModelDate(String aDate){
		if (aDate == null) {
			return true;
		}

		if (aDate.equals("")) {
			return true;
		}

		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");

		if (aDate.length() != 10) {
			return false;
		}

		if (!(aDate.substring(4, 5).equals("-")) ||
			!(aDate.substring(7, 8).equals("-"))){
			return false;
		}

		try {
			Date myDate = myFormatter.parse(aDate);
		}
		catch (ParseException myParseException) {
			return false;
		}

		//YYYY-MM-DD
		//0123456789
		String year = aDate.substring(0,4);
		Integer Year = new Integer(year);
		int myYear = Year.intValue();

		String month = aDate.substring(5,7);
		Integer Month = new Integer(month);
		int myMonth = Month.intValue();

		String day = aDate.substring(8);
		Integer Day = new Integer(day);
		int myDay = Day.intValue();

		if (isValidObjectModelYear(myYear)) {
			if (isValidObjectModelMonth(myMonth)) {
				if (isValidObjectModelDay(myYear, myMonth, myDay)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/*==============================================================*/
	/* OPERATION: isValidObjectModelYear                                                  */
	/*                                                              */
	/**
	 *
	 * @param aYear
	 * @return boolean
	 *
	 */
	/*==============================================================*/

    public static boolean isValidObjectModelYear(int aYear) {
    	boolean validYear = false;
    	if (aYear > 1800){
    		validYear = true;
    	}
    	return validYear;
    }

	/*==============================================================*/
	/* OPERATION: isValidObjectModelDate                                                  */
	/*                                                              */
	/**
	 *
	 * @param aMonth
	 * @return boolean
	 *
	 */
	/*==============================================================*/
    public static boolean isValidObjectModelMonth(int aMonth) {
    	boolean result = false;
    	if (aMonth > 0 && aMonth < 13) {
    		result = true;
    	} else {
    		result = false;
    	}
    	return result;
    }

	/*==============================================================*/
	/* OPERATION: isValidObjectModelDay                                                  */
	/*                                                              */
	/**
	 *
	 * @param aYear
	 * @param aMonth
	 * @param aDay
	 *
	 * @return boolean
	 *
	 */
	/*==============================================================*/
    public static boolean isValidObjectModelDay(int aYear, int aMonth, int aDay) {
    	boolean result = false;

    	result = isValidObjectModelYear(aYear);
    	if (!result) {
    		return result;
    	}
    	result = isValidObjectModelMonth(aMonth);
		if (!result) {
			return result;
		}

		//If they day is 0 or negative then it is an invalid date
		if (aDay <= 0)
		{
			return false;
		}


    	switch (aMonth) {

    	case 4:
    	case 6:
    	case 9:
    	case 11:
    		if (aDay > 30) {
    			result = false;
    		} else {
    			result = true;
			}
			break;
		 case 1:
		 case 3:
		 case 5:
		 case 7:
		 case 8:
		 case 10:
		 case 12:
		 	if (aDay > 31) {
		 		result = false;
		 	} else {
		 		result = true;
		 	}
		 	break;
		case 2:
			GregorianCalendar gc = new GregorianCalendar();
			if (gc.isLeapYear(aYear)) {
				if (aDay > 29) {
					result = false;
				} else {
					result = true;
				}
			} else {
				 if (aDay > 28) {
					result = false;

				 } else {
					result = true;
				 }
			}
			break;
		 default:
		 	result = false;
		}
    	return result;
    }

//TODO WAS
	public static int getYear(String aDate) {
		int myYear = -1;
		if (isValidObjectModelDate(aDate)){
			Integer Year = new Integer(aDate.substring(0,4));
			myYear = Year.intValue();
		}
		return myYear;
	}
	public static String getYearAsString(String aDate) {
		return Integer.toString(getYear(aDate));
	}
	public static int getMonth(String aDate) {
		int myMonth = -1;
		if (isValidObjectModelDate(aDate)){
			Integer Month = new Integer(aDate.substring(5,7));
			myMonth = Month.intValue();
		}
		return myMonth;
	}
	public static String getMonthAsString(String aDate) {
		return Integer.toString(getMonth(aDate));
	}
	public static int getDay(String aDate) {
		int myDay = -1;
		if (isValidObjectModelDate(aDate)){
			Integer Day = new Integer(aDate.substring(8));
			myDay = Day.intValue();
		}
		return myDay;
	}
	public static String getDayAsString(String aDate) {
			return Integer.toString(getDay(aDate));
	}
//	public static Date getDate(String aDate) {
//		Date myDate = null;
//		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
//		if (isValidObjectModelDate(aDate)){
//			try {
//				myDate = myFormatter.parse(aDate);
//			}
//			catch (ParseException myParseException){
//			}
//		}
//		return myDate;
//	}

	/*==================================================================*/
	/* Static Initializer                                               */
	/*==================================================================*/
	/*==============================================================*/
	/* OPERATION: calculateAge                                                  */
	/*                                                              */
	/**
	 *
	 * @param aDateFrom - Date to calculate age from
	 * @param aDateTo - Date to calculate age to
	 * @return int - the age difference
	 *
	 */
	/*==============================================================*/
	public static int calculateAge(Date aDateFrom, Date aDateTo) {
		int result;
		// Prepare a Calendar object for querying values
		Calendar myDateFrom = new GregorianCalendar();
		Calendar myDateTo = new GregorianCalendar();
		myDateFrom.setTime(aDateFrom);
		myDateTo.setTime(aDateTo);
		// Determine rough number of years
		result = myDateTo.get(Calendar.YEAR) - myDateFrom.get(Calendar.YEAR);
		// If the from date has not occurred this year then subtract a year
		myDateFrom.set(Calendar.YEAR, myDateTo.get(Calendar.YEAR));
		if (myDateFrom.after(myDateTo)) {
			result--;
		}
		return result;
	}

	/*==============================================================*/
	/* OPERATION: daysBetween                                                  */
	/*                                                              */
	/**
	 *
	 * @param aDateFrom - Date to calculate age from
	 * @param aDateTo - Date to calculate age to
	 * @return int - the age difference
	 *
	 */
	/*==============================================================*/
	public static long daysBetween(Date aDateFrom, Date aDateTo){
	  final long ONE_HOUR = 60 * 60 * 1000L;
	  return ( (aDateTo.getTime() - aDateFrom.getTime() + ONE_HOUR) /
					(ONE_HOUR * 24));
	   }

	/*==============================================================*/
	/* OPERATION: getStringFormatYYYYMMddWithHyphens                                                  */
	/*                                                              */
	/**
	 *
	 * @param aYear
	 * @param aMonth
	 * @param aDay
	 * @return
	 *
	 */
	/*==================================================================*/
	public static String getStringFormatYYYYMMddWithHyphens(
		String aYear,
		String aMonth,
		String aDay) {

		String myFormattedDate = null;
		boolean myValidDate = false;
		try {
			myValidDate = isValidObjectModelDay(Integer.parseInt(aYear),
				Integer.parseInt(aMonth),
				Integer.parseInt(aDay));
			if (myValidDate){
				StringBuffer myDate = new StringBuffer(10);
				myDate.append(aYear);
				myDate.append("-");
				if (aMonth.length() < 2){
					myDate.append("0");
				}
				myDate.append(aMonth);
				myDate.append("-");
				if (aDay.length() < 2){
					myDate.append("0");
				}
				myDate.append(aDay);
				myFormattedDate = myDate.toString();
			}

		} catch (NumberFormatException myException){
			// Do nothing, just return null
		}

		return myFormattedDate;
	}

	/*==============================================================*/
	/* OPERATION: getStringFormatMMddYYYYWithSlashes                                                  */
	/*                                                              */
	/**
	 *
	 * @param aMonth
	 * @param aDay
	 * @param aYear
	 * @return
	 *
	 */
	/*==================================================================*/
	public static String getStringFormatMMddYYYYWithSlashes(
		String aMonth,
		String aDay,
		String aYear) {

		String myFormattedDate = null;
		boolean myValidDate = false;
		try {
			myValidDate = isValidObjectModelDay(Integer.parseInt(aYear),
				Integer.parseInt(aMonth),
				Integer.parseInt(aDay));
			if (myValidDate){
				StringBuffer myDate = new StringBuffer(10);
				if (aMonth.length() < 2){
					myDate.append("0");
				}
				myDate.append(aMonth);
				myDate.append("/");
				if (aDay.length() < 2){
					myDate.append("0");
				}
				myDate.append(aDay);
				myDate.append("/");
				myDate.append(aYear);
				myFormattedDate = myDate.toString();
			}

		} catch (NumberFormatException myException){
			// Do nothing, just return null
		}

		return myFormattedDate;
	}
	/*==============================================================*/
	/* OPERATION: getStringFormatYYYYMMddWithHyphens                                                  */
	/*                                                              */
	/**
	 *
	 * @param aYear
	 * @param aMonth
	 * @return
	 *
	 */
	/*==================================================================*/
	public static String getStringFormatYYYYMMddWithHyphens(
		String aYear,
		String aMonth) {
			String myDay = FIRST_DAY;
			return getStringFormatYYYYMMddWithHyphens(aYear, aMonth, myDay);
	}

}
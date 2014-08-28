package mdf.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static final String CONTACT_SOURCE_SULEKHA_LEAD = "SULEKHA LEAD";
	public static final String CONTACT_SOURCE_AD_RESPONSE = "AD RESPONSE";
	public static final String CONTACT_SOURCE_REFERAL = "REFERAL";
	public static final String CONTACT_SOURCE_EMAIL_REQUEST = "EMAIL REQUEST";
	public static final String CONTACT_SOURCE_PHONE = "PHONE";
	
	public static final String JAN = "JAN";
	public static final String FEB = "FEB";
	public static final String MAR = "MAR";
	public static final String APR = "APR";
	public static final String MAY = "MAY";
	public static final String JUN = "JUN";
	public static final String JUL = "JUL";
	public static final String AUG = "AUG";
	public static final String SEP = "SEP";
	public static final String OCT = "OCT";
	public static final String NOV = "NOV";
	public static final String DEC = "DEC";

	public static final String MON = "MON";
	public static final String TUE = "TUE";
	public static final String WED = "WED";
	public static final String THU = "THU";
	public static final String FRI = "FRI";
	public static final String SAT = "SAT";
	public static final String SUN = "SUN";
	public static Map monthMap;
	public static Map dayMap;
	static {
		monthMap = new HashMap();
		monthMap.put(JAN, "1");
		monthMap.put(FEB, "2");
		monthMap.put(MAR, "3");
		monthMap.put(APR, "4");
		monthMap.put(MAY, "5");
		monthMap.put(JUN, "6");
		monthMap.put(JUL, "7");
		monthMap.put(AUG, "8");
		monthMap.put(SEP, "9");
		monthMap.put(OCT, "10");
		monthMap.put(NOV, "11");
		monthMap.put(DEC, "12");
		
	}

	static {
		dayMap = new HashMap();
		dayMap.put("1", MON);
		dayMap.put("2", TUE);
		dayMap.put("3", WED);
		dayMap.put("4", THU);
		dayMap.put("5", FRI);
		dayMap.put("6", SAT);
		dayMap.put("7", SUN);
		
	}
}

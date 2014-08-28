package mdf.utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mdf.forms.TicketFormBean;
import mdf.object.PersonName;
import mdf.object.TicketingLine;


public class TicketDataParser {
	
	//define patterns
	// the pattern below defines a nameline for example like: "1.1RAYASAM/KRISHNA KANTH MR"
	// in pattern below: following are groups: 1- (1), 2- (.), 3- (1), 4- (RAYSAM), 5- (KRISHNA), 6- (KANTH), 7- (MR) 
	public static final String nameLineRegEx = "(\\d+)(\\.)(\\d+)(\\w+)/(\\w+)\\s*(\\w*)\\s*(\\w*)";

	// the pattern below defines a ticketline1 for example like: "1 NW8612V 15FEB 5*ORDAMS HK3  1630  0715   16FEB 6 HRS" OR " 1 UA 930W 25DEC 2 SFOLHR HK1  1230  0655   26DEC 3"
	// in pattern below: following are groups: 1- (1), 2- (NW), 3- (8612), 4- (V), 5- (15), 6- (FEB), 7- (5), 8- (ORD), 9- (AMS), 10- (HK), 11- (3), 12- (1630), 13- (0715), 14- (16), 15- (FEB), 16- (6) 
	public static final String ticketLine1RegEx = "(\\d+)\\s+([A-Z]+)\\s*(\\d+)([A-Z])\\s(\\d+)([A-Z]+)\\s(\\d)[\\s\\*]([A-Z]{3})([A-Z]{3})[\\s\\*]([A-Z]K)(\\d)\\s+(\\d+)\\s+(\\d+)";
	
	public static final String ticketLine2aRegEx = "\\s+(\\d+)([A-Z]+)\\s+(\\d)";

	// the pattern below defines a ticketline2b for example like: "/DCNW*42RDMZ /E"
	// in pattern below: following are groups: 1- (DCNW), 2- (42RDMZ), 3- (E) 
	public static final String ticketLine2bRegEx = "/(\\w+)\\*(\\w+)\\s/(\\w)";

	public static final String ssrNotesRegEx = "(\\d+)(\\.)SSR OTHS AA  ";
	
	//define keys
	public static final String NAME_LINE = "NAME_LINE";
	public static final String TICKET_LINE1 = "TICKET_LINE1";
	public static final String TICKET_LINE2B = "TICKET_LINE2B";
	public static final String TICKET_LINE2A = "TICKET_LINE2A";
	public static final String SSR_NOTES = "SSR_NOTES";
	
	public TicketFormBean prepareTicketInfo(String text) {
		List rawLineMapList = new ArrayList();
		TicketFormBean ticketFormBean = new TicketFormBean();
		
		// compile and get reference to pattern objects
		Pattern nameLinePattern = Pattern.compile(nameLineRegEx);
		Pattern ticketLine1Pattern = Pattern.compile(ticketLine1RegEx);
		Pattern ticketLine2aPattern = Pattern.compile(ticketLine2aRegEx);
		Pattern ticketLine2bPattern = Pattern.compile(ticketLine2bRegEx);
		Pattern ssrNotesPattern = Pattern.compile(ssrNotesRegEx);
		// 
		// get a matcher object
		
		String []list = text.split("\n");
		TicketingLine ticketingLine = null;
		ticketingLine = new TicketingLine();
		for (int i=0; i<list.length; i++) {
			String str = list[i].trim(); 
		 	if (str.startsWith("*")) { // display line, ignore
				;
		 	} else if ((str.startsWith("MD"))|| (str.startsWith("MU"))) { // Move down, move up line, ignore
				;
			} else {
				Matcher nameLineMatcher = nameLinePattern.matcher(str);
				Map rawLineMap = new HashMap();
				while (nameLineMatcher.find()) {
					rawLineMap = new HashMap();
					rawLineMap.put(NAME_LINE, str.substring(nameLineMatcher.start(), nameLineMatcher.end()));
					rawLineMapList.add(rawLineMap);
					
					PersonName person = new PersonName();
					if (nameLineMatcher.groupCount() >=4)
						person.setLastName(nameLineMatcher.group(4));
					if (nameLineMatcher.groupCount() >=5)
						person.setFirstName(nameLineMatcher.group(5));
					if (nameLineMatcher.groupCount() >=6) {
						if (nameLineMatcher.groupCount() >=7) {
							person.setMiddleName(nameLineMatcher.group(6));
							person.setTitle(nameLineMatcher.group(7));
						} else { // only 6 parts, either middle name or title is missing!!
							// lets check title against list of standard titles
							String value = nameLineMatcher.group(6);
							if (value.equals("MR") ||
									value.equals("MRS") ||
									value.equals("MS") ||
									value.equals("MISS") ||
									value.equals("MASTER") ||
									value.equals("CHD") ||
									value.equals("CNN") ||
									value.equals("INF") ||
									value.equals("MSTR") ||
									value.equals("DR") ||
									value.equals("REV")) {
								person.setTitle(value);
							} else {
								person.setMiddleName(value);
							}
						}
					}
					ticketFormBean.addPersonName(person);
				}
	
				Matcher ticketLine1Matcher = ticketLine1Pattern.matcher(str);
				while (ticketLine1Matcher.find()) {
					if (ticketingLine == null || ticketingLine.getLineNumber()!= null) ticketingLine = new TicketingLine();
					rawLineMap = new HashMap();
					rawLineMap.put(TICKET_LINE1, str.substring(ticketLine1Matcher.start(), ticketLine1Matcher.end()));
					rawLineMapList.add(rawLineMap);
					
					ticketingLine.setLineNumber(ticketLine1Matcher.group(1));
					ticketingLine.setAirlineCode(ticketLine1Matcher.group(2));
					ticketingLine.setFlightNumber(ticketLine1Matcher.group(3));
					ticketingLine.setClassOfService(ticketLine1Matcher.group(4));
					ticketingLine.setDepartDateOfMonth(ticketLine1Matcher.group(5));
					ticketingLine.setDepartMonth(ticketLine1Matcher.group(6));
					ticketingLine.setDepartDayOfWeek((String)Constants.dayMap.get(ticketLine1Matcher.group(7)));
					ticketingLine.setDepartAirport(ticketLine1Matcher.group(8));
					ticketingLine.setArriveAirport(ticketLine1Matcher.group(9));
					ticketingLine.setConfirmStatus(ticketLine1Matcher.group(10));
					ticketingLine.setNumPax(Integer.parseInt(ticketLine1Matcher.group(11)));
					ticketingLine.setDepartTime(ticketLine1Matcher.group(12));
					ticketingLine.setArriveTime(ticketLine1Matcher.group(13));
					
					if (ticketLine1Matcher.end()<str.length()) {
						// line 2a or 2b is appended in this line itself, lets parse it
						Matcher ticketLine2aMatcher = ticketLine2aPattern.matcher(str.substring(ticketLine1Matcher.end()));
						while (ticketLine2aMatcher.find()) {
							rawLineMap = new HashMap();
							rawLineMap.put(TICKET_LINE2A, ticketLine2aMatcher.group().substring(ticketLine2aMatcher.start(), ticketLine2aMatcher.end()));
							rawLineMapList.add(rawLineMap);
							if (ticketingLine!= null) {
								ticketingLine.setArriveDateOfMonth(ticketLine2aMatcher.group(1));
								ticketingLine.setArriveMonth(ticketLine2aMatcher.group(2));
								ticketingLine.setArriveDayOfWeek((String)Constants.dayMap.get(ticketLine2aMatcher.group(3)));
							}
						}
						Matcher ticketLine2bMatcher = ticketLine2bPattern.matcher(str.substring(ticketLine1Matcher.end()));
					}
				}
				// seperate line with ticketline 2b
				Matcher ticketLine2bMatcher = ticketLine2bPattern.matcher(str);
				while (ticketLine2bMatcher.find()) {
					rawLineMap = new HashMap();
					rawLineMap.put(TICKET_LINE2B, str.substring(ticketLine2bMatcher.start(), ticketLine2bMatcher.end()));
					rawLineMapList.add(rawLineMap);
					if (ticketingLine!= null) {
						ticketingLine.setAirlineConfirmCode(ticketLine2bMatcher.group(2));
					}
				}
				if (ticketingLine != null && ticketingLine.getAirlineConfirmCode()!= null) {
					ticketFormBean.addTicketingLine(ticketingLine);
					ticketingLine = null;
				}
			
				
				Matcher ssrNotesMatcher = ssrNotesPattern.matcher(str);
				while (ssrNotesMatcher.find()) {
					System.out.println("Found ssrNotesLine:" + ssrNotesMatcher.group());
					System.out.println("Start ssrNotesLine:" + ssrNotesMatcher.start());
					System.out.println("End ssrNotesLine:" + ssrNotesMatcher.end());
					System.out.println("Actual SSR notes:" + str.substring(ssrNotesMatcher.start(), ssrNotesMatcher.end()));
					rawLineMap = new HashMap();
					rawLineMap.put(SSR_NOTES, str);
					rawLineMapList.add(rawLineMap);
				}
			}
		}
		for (int i=0;i<rawLineMapList.size(); i++) {
			System.out.println((Map)rawLineMapList.get(i));
		}
		return ticketFormBean;
	}

}

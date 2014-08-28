package mdf.utils;

import java.util.HashMap;
import java.util.Map;

public class StatusConstants {
	/*
	 * public static final String NEW_CONTACT = "NEW_CONTACT"; public static
	 * final String REQUEST_RECEIVED = "REQUEST_RECEIVED"; public static final
	 * String FARE_QUOTE_GIVEN = "FARE_QUOTE_GIVEN"; public static final String
	 * ITINERARY_SENT = "ITINERARY_SENT"; public static final String
	 * FARE_CALCULATED = "FARE_CALCULATED"; public static final String
	 * FOLLOWUP_PENDING = "FOLLOWUP_PENDING"; public static final String
	 * FOLLOWUP_DONE = "FOLLOWUP_DONE"; public static final String
	 * CHANGE_REQUESTED = "ITIN_CHANGE_REQUESTED"; public static final String
	 * PAYMENT_RECEIVED = "PAYMENT_RECEIVED"; public static final String
	 * TICKET_ISSUED = "TICKET_ISSUED"; public static final String
	 * TICKET_DOCS_EMAILED = "TICKET_DOCS_EMAILED"; public static final String
	 * TICKET_DOCS_FEDEXED = "TICKET_DOCS_FEDEXED"; public static final String
	 * TRACKING_SENT = "TRACKING_SENT"; public static final String
	 * TKT_CHANGE_REQUESTED = "TKT_CHANGE_REQUESTED"; public static final String
	 * PENALTY_FARE_GIVEN = "PENALTY_FARE_GIVEN"; public static final String
	 * TICKET_CHANGED_CANCELED = "TICKET_CHANGED_CANCELED"; public static final
	 * String PROMOTION_SENT = "PROMOTION_SENT"; public static final String
	 * COMMISSION_RECEIVED = "COMMISSION_RECEIVED"; public static final String
	 * CLOSED = "CLOSED";
	 */
	public static final String REQUEST_RECEIVED_TO_GIVE_FARE_QUOTE = "REQUEST RECEIVED, TO GIVE FARE QUOTE";

	public static final String REQUEST_RECEIVED_TO_PREPARE_ITIN = "REQUEST RECEIVED, TO PREPARE ITIN";

	public static final String FARE_QUOTE_GIVEN_FOLLOWUP_TO_BE_DONE = "FARE QUOTE GIVEN, FOLLOWUP TO BE DONE";

	public static final String DATE_CHANGE_REQUESTED_TO_PREPARE_ITIN = "DATE CHANGE REQUESTED, TO PREPARE ITIN";

	public static final String ITINERARY_GIVEN_FARES_PENDING = "ITINERARY GIVEN, FARES PENDING";

	public static final String ITINERARY_GIVEN_FOLLOWUP_TO_BE_DONE = "ITINERARY GIVEN, FOLLOWUP TO BE DONE";

	public static final String CALLED_CUSTOMER_VOICEMAIL_LEFT = "CALLED CUSTOMER, VOICEMAIL LEFT";

	public static final String FOLLOWUP_TO_BE_DONE = "FOLLOWUP TO BE DONE";

	public static final String THIRD_FOLLOWUP_DONE_NO_RESPONSE = "PHONE+EMAIL FOLLOWUP DONE, NO RESPONSE";

	public static final String CUSTOMER_WILL_CALL = "CUSTOMER SAID, WILL CALL LATER";

	public static final String CUSTOMER_PLAN_CHANGED = "CUSTOMERS PLAN CANCELED OR POSTPONED";

	public static final String CUSTOMER_PURCAHSED_TICKETS_ELSEWHERE = "CUSTOMER PURCAHSED TICKETS ELSEWHERE";

	public static final String CUSTOMER_LOST = "CUSTOMER LOST";

	public static final String TICKET_ISSUED_TO_SEND_DOCS = "TICKET ISSUED, TO SEND DOCS";

	public static final String DOCUMENT_EMAILED_TO_FEDEX_DOCS = "DOCUMENT EMAILED, TO FEDEX DOCS";

	public static final String FEDEX_SENT_TO_CLOSE = "FEDEX SENT, TO CLOSE";

	public static final String OTHER = "OTHER";

	public static final String CLOSED = "CLOSED";

	public static final String STATE_ITIN = "STATE ITINERARY";

	public static final String STATE_FOLLOWUP = "STATE FOLLOWUP";

	public static final String STATE_DOCS = "STATE DOCS";

	public static final String STATE_FAILED = "STATE FAILED";

	public static final String STATE_CLOSED = "STATE CLOSED";

	public static Map stateMap;
	static {
		stateMap = new HashMap();
		stateMap.put(REQUEST_RECEIVED_TO_GIVE_FARE_QUOTE, STATE_ITIN);
		stateMap.put(REQUEST_RECEIVED_TO_PREPARE_ITIN, STATE_ITIN);
		stateMap.put(FARE_QUOTE_GIVEN_FOLLOWUP_TO_BE_DONE, STATE_FOLLOWUP);
		stateMap.put(DATE_CHANGE_REQUESTED_TO_PREPARE_ITIN, STATE_ITIN);
		stateMap.put(ITINERARY_GIVEN_FARES_PENDING, STATE_ITIN);

		stateMap.put(ITINERARY_GIVEN_FOLLOWUP_TO_BE_DONE, STATE_FOLLOWUP);
		stateMap.put(CALLED_CUSTOMER_VOICEMAIL_LEFT, STATE_FOLLOWUP);
		stateMap.put(FOLLOWUP_TO_BE_DONE, STATE_FOLLOWUP);
		stateMap.put(THIRD_FOLLOWUP_DONE_NO_RESPONSE, STATE_FOLLOWUP);

		stateMap.put(CUSTOMER_WILL_CALL, STATE_FAILED);
		stateMap.put(CUSTOMER_PLAN_CHANGED, STATE_FAILED);
		stateMap.put(CUSTOMER_PURCAHSED_TICKETS_ELSEWHERE, STATE_FAILED);
		stateMap.put(CUSTOMER_LOST, STATE_FAILED);

		stateMap.put(TICKET_ISSUED_TO_SEND_DOCS, STATE_DOCS);
		stateMap.put(DOCUMENT_EMAILED_TO_FEDEX_DOCS, STATE_DOCS);

		stateMap.put(FEDEX_SENT_TO_CLOSE, STATE_CLOSED);
		stateMap.put(OTHER, STATE_ITIN);
		stateMap.put(CLOSED, STATE_CLOSED);

		stateMap.put("", "");
	}
}

<!--
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*" %>
<%@ page import="mdf.forms.*" %>
-->
<LINK HREF="css/mdfstyles.css" TYPE="text/css" REL="stylesheet" />
<HTML>
<HEAD>
	<TITLE>MYDREAMFLIGHT ETICKET <c:out value='${ticketFormBean.bill_to}'/> <c:out value='${ticketFormBean.pnr}'/></TITLE>
    <SCRIPT language="JavaScript">
        function setAction(choice, form) {
			form.actionn.value = choice;
			form.action = "ticket_action.do";
            form.submit();
        }
    </SCRIPT>
</HEAD>
	<BODY style="background-color:white">
	<!-- A4 size is 21 cm * 29.7 cm LESS PAGE BORDER -->
	<table style="width: 190mm">
		<TR><TD>
			<!-- Header goes here -->
			<table border=0 width=100%>
			<TR>
				<TD style="text-align:right">
					<img src="img/mydreamflight_logo_small.jpg" align="left" style="margin-right:15px ">
				</TD>
				<TD></TD>
				<TD style="text-align:right">
					<table class="invoice_header" style="font-size: 8pt; color: gray; font-family: Georgia">
						<TR align=left><TD>MY DREAM FLIGHT</TD></TR>
						<TR align=left><TD>3845 COVENTRY PARK LN</TD></TR>
						<TR align=left><TD>DULUTH GA 30096-2420</TD></TR>
						<TR align=left><TD>Tel: 877-FLY-DREAM/ 877-3593732</TD></TR>
						<TR align=left><TD>Fax: 6178450397</TD></TR>
						<TR align=left><TD>www.mydreamflight.com</TD></TR>
					</table>
				</TD>
			</TR>
			</table>
		</TD></TR>	
	    <TR><TD>
			<!-- content goes here -->
			<table>
			<TR><TD class="invoice_text">
				<table width=100%>
					<TR><TD>
						<c:if test="${ticketFormBean.ticket_type == 'ETICKET RECEIPT'}">
						<B>E-TICKET</B>
						</c:if>
						<c:if test="${ticketFormBean.ticket_type == 'PAPER'}">
						<B>PAPER-TICKET DUPLICATE COPY (THIS IS NOT YOUR TICKET)</B>
						</c:if>
					</TD></TR>

					<TR>
					<TD>
						<table border=1>
							<TR>
								<TD><B>Transaction #</B></TD>
								<TD><c:out value="${ticketFormBean.transaction_number}"/></TD>
							</TR>
							<TR>
								<TD><B>Issue Date</B></TD>
								<TD><c:out value="${ticketFormBean.issue_date}"/></TD>
							</TR>
							<TR>
								<TD><B>PNR #</B></TD>
								<TD><B><c:out value="${ticketFormBean.pnr}"/></b></TD>
							</TR>
							<!-- spacer row -->
							<TR><TD colspan=2>&nbsp;</TD></TR>
							
							<c:if test="${ticketFormBean.airlineInfoLines != null}">
							<TR>
							<TD colspan=2><B>Airline Confirmation Codes:</B></TD>
							</TR>
							<logic:iterate name="ticketFormBean" property="airlineInfoLines" id="airlineInfoLine">
							<TR>
								<TD>
									<bean:write name="airlineInfoLine" property="airlineName"/>
								</TD>
								<TD>
									<bean:write name="airlineInfoLine" property="airlineConfirmCode"/>
								</TD>
							</TR>
							</logic:iterate>
							</c:if>
								
							<!-- spacer row -->
							<TR><TD colspan=2>&nbsp;</TD></TR>

							<TR>
								<TD colspan=2><B>Ticket Numbers:</B></TD>
							</TR>
							<c:if test="${ticketFormBean.pax1Last_name != ''}">
							<TR>
								<TD>
									<bean:write name="ticketFormBean" property="pax1Title"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax1First_name"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax1Middle_name"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax1Last_name"/>
								</TD>
								<TD>
									<bean:write name="ticketFormBean" property="pax1Description"/>
								</TD>
							</TR>
							</c:if>
							<c:if test="${ticketFormBean.pax2Last_name != ''}">
							<TR>
								<TD>
									<bean:write name="ticketFormBean" property="pax2Title"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax2First_name"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax2Middle_name"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax2Last_name"/>
								</TD>
								<TD>
									<bean:write name="ticketFormBean" property="pax2Description"/>
								</TD>
							</TR>
							</c:if>
							<c:if test="${ticketFormBean.pax3Last_name != ''}">
							<TR>
								<TD>
									<bean:write name="ticketFormBean" property="pax3Title"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax3First_name"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax3Middle_name"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax3Last_name"/>
								</TD>
								<TD>
									<bean:write name="ticketFormBean" property="pax3Description"/>
								</TD>
							</TR>
							</c:if>
							<c:if test="${ticketFormBean.pax4Last_name != ''}">
							<TR>
								<TD>
									<bean:write name="ticketFormBean" property="pax4Title"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax4First_name"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax4Middle_name"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax4Last_name"/>
								</TD>
								<TD>
									<bean:write name="ticketFormBean" property="pax4Description"/>
								</TD>
							</TR>
							</c:if>
							<c:if test="${ticketFormBean.pax5Last_name != ''}">
							<TR>
								<TD>
									<bean:write name="ticketFormBean" property="pax5Title"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax5First_name"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax5Middle_name"/>&nbsp;
									<bean:write name="ticketFormBean" property="pax5Last_name"/>
								</TD>
								<TD>
									<bean:write name="ticketFormBean" property="pax5Description"/>
								</TD>
							</TR>
							</c:if>
							
						</table>
					</TD>
					</TR>
					
					<!-- spacer row -->
					<TR><TD>&nbsp;</TD></TR>

					<TR><TD>
						<table border=1 width=100%>
						<tr>
						<TD>
							<table><TR>
								<TD><B>Depart Date:</B></TD>
								<TD><bean:write name="ticketFormBean" property="depart_date"/></TD>
							</TR></table>
						</TD>
						<TD>
							<table><TR>
								<TD><B>Depart Airport:</B></TD>
								<TD><bean:write name="ticketFormBean" property="depart_airport"/></TD>
							</TR></table>
						</TD>
						<TD>
							<table><TR>
								<TD><B>Issuing IATA:</B></TD>
								<TD><bean:write name="ticketFormBean" property="issuing_iata"/></TD>
							</TR></table>
						</TD>
						</tr></table>
					</TD>
					</TR>

					<!-- spacer row -->
					<TR><TD>&nbsp;</TD></TR>

					<TR><TD>
					<!-- ITINERARY -->
					<table table border=1 width=100%>
						<tr><td colspan=14><B><span class='highlight'>ITINERARY</span></B></td></tr>
						<c:if test="${ticketFormBean.linePresent == 'true'}">
						<TR>
							<TD rowspan=2><B>SN</B></TD>
							<TD rowspan=2><B>Airline</B></TD>
							<TD rowspan=2><B>Flight</B></TD>
							<TD colspan=5><B>Departure</B></TD>
							<TD colspan=5><B>Arrival</B></TD>
							<TD rowspan=2><B>Airline confirmation code</B></TD>
						</TR>
						<TR>
							<TD><B>Date</B></TD>
							<TD><B>Month</B></TD>
							<TD><B>Day</B></TD>
							<TD><B>Time</B></TD>
							<TD><B>Airport</B></TD>
							<TD><B>Airport</B></TD>
							<TD><B>Date</B></TD>
							<TD><B>Month</B></TD>
							<TD><B>Day</B></TD>
							<TD><B>Time</B></TD>
						</TR>
						<logic:iterate name="ticketFormBean" property="ticketingLines" id="ticketingLine">
						<TR>
							<TD><bean:write name="ticketingLine" property="lineNumber"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="airlineCode"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="flightNumber"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="departDateOfMonth"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="departMonth"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="departDayOfWeek"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="departTime"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="departAirport"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="arriveAirport"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="arriveDateOfMonth"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="arriveMonth"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="arriveDayOfWeek"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="arriveTime"/>&nbsp;</TD>
							<TD><bean:write name="ticketingLine" property="airlineConfirmCode"/>&nbsp;</TD>
						</TR>
						</logic:iterate>
					</c:if>
					<c:if test="${ticketFormBean.linePresent != 'true'}">
						<tr><td colspan=14><em>Itinerary not uploaded from Sabre data</em></td></tr>
					</c:if>
					</table>
					</TD></TR>
		
					<TR><TD><B>Link&nbsp;:</B>&nbsp;<bean:write name="ticketFormBean" property="itinerary_link"/>
					</TD></TR>

					<!-- spacer row -->
					<TR><TD>&nbsp;</TD></TR>

					<TR><TD>
						<!-- comments row -->
						<table style="FONT-FAMILY: 'Courier';font-size:9px;	text-align: justify;">
							<tr><td><B>COMMENTS TO PASSENGER</B></td></tr>
							<tr><td><em>
							<c:if test="${ticketFormBean.comments != ''}">
							<c:out value="${ticketFormBean.comments}"/>
							<BR/>
							</c:if>
							Have a safe flight</em>
							</td></tr>
						</table>
					</TD></TR>

					<TR><TD>
						<!-- terms row -->
						<table style="FONT-FAMILY: 'Courier';font-size:9px;	text-align: justify;">
							<tr><td><B>TERMS</B></td></tr>
							<tr><td>Please inspect your tickets immediately. MyDreamFlight will not be responsible for errors if detected after 24 hours of delivery.</td></tr>
							<tr><td>Check-in for International flights at least 3 hours before departure.</td></tr>
							<tr><td>Check-in for domestic flights at least 2 hours before departure.</td></tr>
							<tr><td>All tickets are restricted and carry a cancellation penalty.</td></tr>
							<tr><td>A $25 service charge applies once tickets are returned.</td></tr>
							<tr><td>Other restrictions and liability limitations apply. A complete description is available on our website www.mydreamflight.com</td></tr>
							<tr><td>Please recheck the visa requirements with the airline/ consulate prior to departure.</td></tr>
							<tr><td>Please confirm your seat, meal and any other special request(eg bassinet, etc.) with airline 72 hours before departure.</td></tr>
							<tr><td>Please reconfirm your flights 72 hours before departure.</td></tr>
							<tr><td>For more information on your transit visa, trip planning, travel insurance and more please visit on our website www.mydreamflight.com</td></tr>
							<tr><td>We appreciate your business and hope to serve you again.</td></tr>
							<tr><td style="text-align:center">Thank you for Choosing MYDREAMFLIGHT</td></tr>
							<tr><td style="text-align:center">
		                        <em>-providing wings to your dream</em></td></tr>
						</table>
					</TD></TR>
					
					<TR><TD>
						<!-- questions row -->
						<table style="FONT-FAMILY: 'Courier';font-size:9px;	text-align: justify;">
							<tr><td><B>QUESTIONS / HELP </B></td></tr>
							<tr><td>If you have any questions- please call us at 877-FLY-DREAM / 6176004641 or email us at customercare@mydreamflight.com or visit us online at www.mydreamflight.com for live assistance.</td></tr>
							<tr><td>In case of any emergency- please call at any one of the following numbers:</td></tr>
							<tr><td>877-FLY-DREAM / 2074230657 / 3095332071 / 6176337922</td></tr>
						</table>
					</TD></TR>

					<TR><TD>
						<!-- promotions row -->
						<table style="FONT-FAMILY: 'Courier';font-size:9px;	text-align: justify;">
							<tr><td><B>PROMO MESSAGES</B></td></tr>
							<tr><td>Call us to plan a stop over at no extra charge on your way to the final destination.</td></tr>
							<tr><td>Visit www.mydreamflight.com for useful transit visa information and rules.</td></tr>
							<tr><td>Ask us for a combination package with a hotel to save more on your trip.</td></tr>
						</table>
					</TD></TR>

			</table>
			
		</TD></TR>
	</table>
	</BODY>
</HTML>
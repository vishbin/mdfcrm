<!--
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*" %>
<%@ page import="mdf.forms.*" %>
-->
<LINK HREF="css/mdfstyles.css" TYPE="text/css" REL="stylesheet" />
<HTML>
<HEAD>
	<TITLE>MYDREAMFLIGHT INVOICE <c:out value='${ticketFormBean.bill_to}'/> <c:out value='${ticketFormBean.invoice_number}'/></TITLE>
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
				<TD align=right>
					<img src="img/mydreamflight_logo_small.jpg" align="left" style="margin-right:15px ">
				</TD>
				<TD></TD>
				<TD align=right>
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
					<TR>
						<!-- column 1 -->
						<TD align=left style="width: 290px;font-size:10">
							<table border=1 width=100%>
								<TR><TD><B>MY DREAM FLIGHT</B></TD></TR>
								<TR><TD>3845 COVENTRY PARK LN</TD></TR>
								<TR><TD>DULUTH GA 30096-2420</TD></TR>
								<TR><TD>PH: 877FLYDREAM FAX: 6178450397</TD></TR>
							</table>
						</TD>
						<TD></TD>
						<!-- column 2 -->
						<TD align=right style="float: right;width: 285px">
							<table border=1 width=100%>
								<TR>
									<TD>Transaction #</TD>
									<TD><c:out value="${ticketFormBean.transaction_number}"/></TD>
									<TD>Date</TD>
									<TD><c:out value="${ticketFormBean.issue_date}"/></TD>
								</TR>
								<TR>
									<TD>Branch ID</TD>
									<TD><c:out value="${ticketFormBean.branch_id}"/></TD>
									<TD>Invoice #</TD>
									<TD><c:out value="${ticketFormBean.invoice_number}"/></TD>
								</TR>
								<TR>
									<TD>FST</TD>
									<TD>&nbsp;</TD>
									<TD>Page</TD>
									<TD>1</TD>
								</TR>
								<TR>
									<TD>Offset</TD>
									<TD>&nbsp;</TD>
									<TD>Registration</TD>
									<TD>&nbsp;</TD>
								</TR>
							</table>
						</TD>
					</TR>
					<TR><TD colspan=3>
						<B>STATEMENT / INVOICE</B>
					</TD></TR>
					<TR>
						<TD style="width: 290px">
						<B><span class='highlight'>Bill To:</span></B>
						</TD>
						<TD></TD>
						<TD style="width: 285px;float: right;">
						<B><span class='highlight'>Mail To:</span></B>
						</TD>
					</TR>
					<TR>
						<TD style="width: 290px">
							<table border=1 width=100%>
								<TR><TD><c:out value="${ticketFormBean.bill_to}"/></TD></TR>
								<TR><TD><c:out value="${ticketFormBean.billingAddress_line1}"/></TD></TR>
								<TR><TD><c:out value="${ticketFormBean.billingAddress_line2}"/></TD></TR>
								<TR><TD><c:out value="${ticketFormBean.billingAddress_city}"/></TD></TR>
								<TR><TD><c:out value="${ticketFormBean.billingAddress_state}"/> <c:out value="${ticketFormBean.billingAddress_zip}"/>
									<c:if test="${ticketFormBean.billingAddress_country != 'US'}">
										&nbsp;<c:out value="${ticketFormBean.billingAddress_country}"/>
									</c:if>
								</TD></TR>
							</table>
						</TD>
						<TD></TD>
						<TD style="width: 285px;float: right;" align=right>
							<table border=1 width=100%>
								<TR><TD><c:out value="${ticketFormBean.mail_to}"/></TD></TR>
								<TR><TD><c:out value="${ticketFormBean.mailingAddress_line1}"/></TD></TR>
								<TR><TD><c:out value="${ticketFormBean.mailingAddress_line2}"/></TD></TR>
								<TR><TD><c:out value="${ticketFormBean.mailingAddress_city}"/></TD></TR>
								<TR><TD><c:out value="${ticketFormBean.mailingAddress_state}"/> <c:out value="${ticketFormBean.mailingAddress_zip}"/>
									<c:if test="${ticketFormBean.mailingAddress_country != 'US'}">
										&nbsp;<c:out value="${ticketFormBean.mailingAddress_country}"/>
									</c:if>
								</TD></TR>
							</table>
						</TD>
					</TR>
				</table>
				
			</TD></TR>
			<TR><TD>
				<!-- File information -->
				<table width=100% border=1>
					<TR>
						<TD><B>Filename</B></TD>
						<TD><B>Sales Type</B></TD>
						<TD><B>Ticketing</B></TD>
						<TD><B>Sales rep</B></TD>
						<TD><B>Contact</B></TD>
						<TD><B>Head Count</B></TD>
					</TR>
					<TR>
						<TD><c:out value="${ticketFormBean.pnr}"/></TD>
						<TD><c:out value="${ticketFormBean.ticket_type}"/></TD>
						<TD><c:out value="${ticketFormBean.ticket_issuer}"/></TD>
						<TD><c:out value="${ticketFormBean.agent_name}"/></TD>
						<TD><c:out value="${ticketFormBean.agent_name}"/></TD>
						<TD><c:out value="${ticketFormBean.num_pax}"/></TD>
					</TR>
				</table>
			</TD></TR>
			<!-- spacer row -->
			<TR><TD>&nbsp;</TD></TR>
			<TR><TD>
				<!-- sales details -->
				<table border=1 width=100%>
					<TR><TD colspan=8><B>Sales Details</B></TD></TR>
					<TR>
						<TD>Item</TD>
						<TD>Ticket #/Description</TD>
						<TD>Passenger Name</TD>
						<TD>Fare</TD>
						<TD>Taxes</TD>
						<TD>Surcharge</TD>
						<TD>Total</TD>
						<TD>Currency</TD>
					</TR>

					<c:if test="${ticketFormBean.pax1Last_name != ''}">
                    <TR>
						<TD>1</TD>
						<TD><c:out value="${ticketFormBean.pax1Description}"/></TD>
						<TD><c:out value="${ticketFormBean.pax1Last_name}"/>
							<c:if test="${ticketFormBean.pax1First_name != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax1First_name}"/>
							</c:if>
							<c:if test="${ticketFormBean.pax1Middle_name != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax1Middle_name}"/>
							</c:if>
							<c:if test="${ticketFormBean.pax1Title != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax1Title}"/>
							</c:if>
						</TD>
						<TD><c:out value="${ticketFormBean.pax1Base}"/></TD>
						<TD><c:out value="${ticketFormBean.pax1Tax}"/></TD>
						<TD><c:out value="${ticketFormBean.pax1Surcharge}"/></TD>
						<TD><c:out value="${ticketFormBean.pax1Charge}"/></TD>
						<TD><c:out value="${ticketFormBean.pax1Currency}"/></TD>
					</TR>
					</c:if>

					<c:if test="${ticketFormBean.pax2Last_name != ''}">
                    <TR>
						<TD>2</TD>
						<TD><c:out value="${ticketFormBean.pax2Description}"/></TD>
						<TD><c:out value="${ticketFormBean.pax2Last_name}"/>
							<c:if test="${ticketFormBean.pax2First_name != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax2First_name}"/>
							</c:if>
							<c:if test="${ticketFormBean.pax2Middle_name != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax2Middle_name}"/>
							</c:if>
							<c:if test="${ticketFormBean.pax2Title != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax2Title}"/>
							</c:if>
						</TD>
						<TD><c:out value="${ticketFormBean.pax2Base}"/></TD>
						<TD><c:out value="${ticketFormBean.pax2Tax}"/></TD>
						<TD><c:out value="${ticketFormBean.pax2Surcharge}"/></TD>
						<TD><c:out value="${ticketFormBean.pax2Charge}"/></TD>
						<TD><c:out value="${ticketFormBean.pax2Currency}"/></TD>
					</TR>
					</c:if>

					<c:if test="${ticketFormBean.pax3Last_name != ''}">
                    <TR>
						<TD>3</TD>
						<TD><c:out value="${ticketFormBean.pax3Description}"/></TD>
						<TD><c:out value="${ticketFormBean.pax3Last_name}"/>
							<c:if test="${ticketFormBean.pax3First_name != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax3First_name}"/>
							</c:if>
							<c:if test="${ticketFormBean.pax3Middle_name != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax3Middle_name}"/>
							</c:if>
							<c:if test="${ticketFormBean.pax3Title != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax3Title}"/>
							</c:if>
						</TD>
						<TD><c:out value="${ticketFormBean.pax3Base}"/></TD>
						<TD><c:out value="${ticketFormBean.pax3Tax}"/></TD>
						<TD><c:out value="${ticketFormBean.pax3Surcharge}"/></TD>
						<TD><c:out value="${ticketFormBean.pax3Charge}"/></TD>
						<TD><c:out value="${ticketFormBean.pax3Currency}"/></TD>
					</TR>
					</c:if>

					<c:if test="${ticketFormBean.pax4Last_name != ''}">
                    <TR>
						<TD>4</TD>
						<TD><c:out value="${ticketFormBean.pax4Description}"/></TD>
						<TD><c:out value="${ticketFormBean.pax4Last_name}"/>
							<c:if test="${ticketFormBean.pax4First_name != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax4First_name}"/>
							</c:if>
							<c:if test="${ticketFormBean.pax4Middle_name != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax4Middle_name}"/>
							</c:if>
							<c:if test="${ticketFormBean.pax4Title != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax4Title}"/>
							</c:if>
						</TD>
						<TD><c:out value="${ticketFormBean.pax4Base}"/></TD>
						<TD><c:out value="${ticketFormBean.pax4Tax}"/></TD>
						<TD><c:out value="${ticketFormBean.pax4Surcharge}"/></TD>
						<TD><c:out value="${ticketFormBean.pax4Charge}"/></TD>
						<TD><c:out value="${ticketFormBean.pax4Currency}"/></TD>
					</TR>
					</c:if>

					<c:if test="${ticketFormBean.pax5Last_name != ''}">
                    <TR>
						<TD>5</TD>
						<TD><c:out value="${ticketFormBean.pax5Description}"/></TD>
						<TD><c:out value="${ticketFormBean.pax5Last_name}"/>
							<c:if test="${ticketFormBean.pax5First_name != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax5First_name}"/>
							</c:if>
							<c:if test="${ticketFormBean.pax5Middle_name != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax5Middle_name}"/>
							</c:if>
							<c:if test="${ticketFormBean.pax5Title != ''}">
							&nbsp;<c:out value="${ticketFormBean.pax5Title}"/>
							</c:if>
						</TD>
						<TD><c:out value="${ticketFormBean.pax5Base}"/></TD>
						<TD><c:out value="${ticketFormBean.pax5Tax}"/></TD>
						<TD><c:out value="${ticketFormBean.pax5Surcharge}"/></TD>
						<TD><c:out value="${ticketFormBean.pax5Charge}"/></TD>
						<TD><c:out value="${ticketFormBean.pax5Currency}"/></TD>
					</TR>
					</c:if>

					<TR>
						<TD colspan=3><B>Sales Totals:</B></TD>
						<TD><c:out value="${ticketFormBean.totalBase}"/></TD>
						<TD><c:out value="${ticketFormBean.totalTax}"/></TD>
						<TD><c:out value="${ticketFormBean.totalSurcharge}"/></TD>
						<TD><c:out value="${ticketFormBean.totalCharge}"/></TD>
						<TD><c:out value="${ticketFormBean.totalCurrency}"/></TD>
					</TR>
				</TABLE>
			</TD></TR>
			<TR><TD>
				<table>
					<TR>
						<TD>Form of payment</TD>
						<TD><c:out value="${ticketFormBean.form_of_payment}"/></TD>
					</TR>
				</table>
			</TD></TR>
			<TR><TD>
				<TABLE>
				<c:if test="${ticketFormBean.form_of_payment == 'CC'}">
				<TR><TD>
					<TABLE border=1>
						<TR>
							<TD colspan=2><B>CC DETAILS</B></TD>
						</TR>
						<TR>
							<TD>Ending</TD>
							<TD>Card Type</TD>
						</TR>
						<TR>
							<TD><c:out value="${ticketFormBean.card_number}"/></TD>
						    <TD><c:out value="${ticketFormBean.card_type}"/></TD>
						</TR>
					</TABLE>
				</TD></TR>
				</c:if>
				<c:if test="${ticketFormBean.form_of_payment == 'CHECK'}">
				<TR><TD>
					<TABLE border=1>
						<TR>
							<TD colspan=2><B>CHECK DEATILS</B></TD>
						</TR>
						<TR>
							<TD>Check Number</TD>
							<TD>Bank Name</TD>
						</TR>
						<TR>
							<TD><c:out value="${ticketFormBean.check_number}"/></TD>
							<TD><c:out value="${ticketFormBean.bank_name}"/></TD>
						</TR>
					</TABLE>
				</TD></TR>
				</c:if>
				<c:if test="${ticketFormBean.form_of_payment == 'CASH'}">
				<TR><TD>
					<TABLE border=1>
						<TR>
							<TD colspan=2><B>CASH DEATILS</B></TD>
						</TR>
						<TR>
							<TD>Received By</TD>
							<TD><c:out value="${ticketFormBean.receivedBy}"/></TD>
						</TR>
					</TABLE>
				</TD></TR>
				</c:if>
				</TABLE>

			</TD></TR>

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

			</table>
			
		</TD></TR>
	</table>
	</BODY>
</HTML>
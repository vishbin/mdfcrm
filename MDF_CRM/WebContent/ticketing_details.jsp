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
	<TITLE>Ticket List</TITLE>
    <SCRIPT language="JavaScript">
        function setAction(choice, form) {
/*
        	if (choice == 'printInvoice' || choice == 'printEticket') {
        		var ans = confirm('You must SAVE your changes before you print. Do you want to RE-SAVE?');
        		if (ans == true) {
	        		alert('OK. Click the save button before proceeding to print');
        		}
            }
*/
        	form.actionn.value = choice;
			form.action = "ticket_action.do";
            form.submit();
        }
        function updateTotal(obj) {
       		var form = document.forms[0];
        	if (obj.name.indexOf('pax1') ==0 && obj.name.indexOf('pax1Charge') == -1)  {
        		form.pax1Charge.value = parseFloat(form.pax1Base.value) + parseFloat(form.pax1Tax.value) + parseFloat(form.pax1Surcharge.value);
        	} else if (obj.name.indexOf('pax2') ==0 && obj.name.indexOf('pax2Charge') == -1)  {
        		form.pax2Charge.value = parseFloat(form.pax2Base.value) + parseFloat(form.pax2Tax.value) + parseFloat(form.pax2Surcharge.value);
        	} else if (obj.name.indexOf('pax3') ==0 && obj.name.indexOf('pax3Charge') == -1)  {
        		form.pax2Charge.value = parseFloat(form.pax3Base.value) + parseFloat(form.pax3Tax.value) + parseFloat(form.pax3Surcharge.value);
        	} else if (obj.name.indexOf('pax4') ==0 && obj.name.indexOf('pax4Charge') == -1)  {
        		form.pax2Charge.value = parseFloat(form.pax4Base.value) + parseFloat(form.pax4Tax.value) + parseFloat(form.pax4Surcharge.value);
        	} else if (obj.name.indexOf('pax5') ==0 && obj.name.indexOf('pax5Charge') == -1)  {
        		form.pax2Charge.value = parseFloat(form.pax5Base.value) + parseFloat(form.pax5Tax.value) + parseFloat(form.pax5Surcharge.value);
        	}
        	if (obj.name.indexOf('Base') >0)  {
        		form.totalBase.value = parseFloat(form.pax1Base.value) + parseFloat(form.pax2Base.value) + parseFloat(form.pax3Base.value) + parseFloat(form.pax4Base.value) + parseFloat(form.pax5Base.value);
			} else if (obj.name.indexOf('Tax') >0)  {
        		form.totalTax.value = parseFloat(form.pax1Tax.value) + parseFloat(form.pax2Tax.value) + parseFloat(form.pax3Tax.value) + parseFloat(form.pax4Tax.value) + parseFloat(form.pax5Tax.value);
        	} else if (obj.name.indexOf('Surcharge') >0)  {
        		form.totalSurcharge.value = parseFloat(form.pax1Surcharge.value) + parseFloat(form.pax2Surcharge.value) + parseFloat(form.pax3Surcharge.value) + parseFloat(form.pax4Surcharge.value) + parseFloat(form.pax5Surcharge.value);
			}
       		form.totalCharge.value = parseFloat(form.pax1Charge.value) + parseFloat(form.pax2Charge.value) + parseFloat(form.pax3Charge.value) + parseFloat(form.pax4Charge.value) + parseFloat(form.pax5Charge.value);
        }
    </SCRIPT>
</HEAD>
<BODY bgcolor="#9f9fff">
<H1 class="blue">MyDreamFlight Ticket List</H1>
		<html:form action="/ticket_action.do" >
		<table>
		<TR><TD>
			<html:submit value="CREATE NEW" onclick="return setAction('add', this.form)"></html:submit>
			<html:submit value="SAVE" onclick="return setAction('save', this.form)"></html:submit>
			<html:submit value="DELETE" onclick="return setAction('softDelete', this.form)"></html:submit>
			<html:submit value="REFRESH" onclick="return setAction('refresh', this.form)"></html:submit>
			<html:submit value="UPLOAD & SAVE SABRE DATA" onclick="return setAction('updateTicketingData', this.form)"></html:submit>
			<html:submit value="SAVE & PRINT ETICKET" onclick="return setAction('printEticket', this.form)"></html:submit>
			<html:submit value="SAVE & PRINT INVOICE" onclick="return setAction('printInvoice', this.form)"></html:submit>
		    <html:hidden property="actionn" value="ADD"/>
		    <html:hidden property="add_dttm"/>
		    <html:hidden property="update_dttm"/>
		    <html:hidden property="delete_dttm"/>
		    <html:hidden property="added_by"/>
		    <html:hidden property="updated_by"/>
		    <html:hidden property="contact_id"/>
		    <html:hidden property="ticket_id"/>
		    <html:hidden property="insert_key"/>
		
			<html:hidden property="invoice_number"/>
			<!-- content goes here -->
			<table>
			
			<TR><TD>
				<table>
					<TR>
						<!-- column 2 -->
						<TD>
							<table border=1>
								<TR>
									<TD>Transaction #</TD>
									<TD><html:text property="transaction_number" size="4" maxlength="10"></html:text></TD>
									<TD>Issue Date (MM/dd/yyyy)</TD>
									<TD><html:text property="issue_date" size="10" maxlength="15"></html:text></TD>
								</TR>
								<TR>
									<TD>Branch ID</TD>
									<TD><html:text property="branch_id" size="2" maxlength="5"></html:text></TD>
									<TD>Invoice #</TD>
									<TD><html:text property="invoice_number" disabled="true" size="4" maxlength="10"></html:text></TD>
								</TR>
							</table>
						</TD>
					</TR>
					<TR>
						<TD>
						<B><span style='font-size:12.0pt;font-family:"Times New Roman";color:white;background:black;'>Bill To:</span></B>
						</TD>
						<TD>
						<B><span style='font-size:12.0pt;font-family:"Times New Roman";color:white;background:black;'>Mail To:</span></B>
						</TD>
					</TR>
					<TR>
						<TD>
							<table border=1>
								<TR><TD><html:text property="bill_to" size="40" maxlength="50"></html:text></TD></TR>
								<TR><TD>Address 1 &nbsp;<html:text property="billingAddress_line1" size="10"></html:text></TD></TR>
								<TR><TD>Address 2 &nbsp;<html:text property="billingAddress_line2" size="10"></html:text></TD></TR>
							    <tr><td>City &nbsp;<html:text property="billingAddress_city" size="10"></html:text> &nbsp; State &nbsp;<html:text property="billingAddress_state" size="2"></html:text></td></tr>
							    <tr><td>Zip &nbsp;<html:text property="billingAddress_zip" size="4"></html:text> &nbsp; Country &nbsp;<html:text property="billingAddress_country" size="8"></html:text></td></tr>
							</table>
						</TD>
						<TD>
							<table border=1>
								<TR><TD><html:text property="mail_to" size="40" maxlength="50"></html:text></TD></TR>
								<TR><TD>Address 1 &nbsp;<html:text property="mailingAddress_line1" size="10"></html:text></TD></TR>
								<TR><TD>Address 2 &nbsp;<html:text property="mailingAddress_line2" size="10"></html:text></TD></TR>
							    <tr><td>City &nbsp;<html:text property="mailingAddress_city" size="10"></html:text> &nbsp; State &nbsp;<html:text property="mailingAddress_state" size="2"></html:text></td></tr>
							    <tr><td>Zip &nbsp;<html:text property="mailingAddress_zip" size="4"></html:text> &nbsp; Country &nbsp;<html:text property="mailingAddress_country" size="8"></html:text></td></tr>
							</table>
						</TD>
					</TR>
				</table>
				
			</TD></TR>
			<!-- spacer row -->
			<TR><TD>&nbsp;</TD></TR>
			<TR><TD>
				<!-- File information -->
				<table>
					<TR>
						<TD>PNR</TD>
						<TD>CRS</TD>
						<TD>Sales Type</TD>
						<TD>Ticket Type</TD>
						<TD>Ticket Issuer</TD>
						<TD>Sales rep</TD>
						<TD>Contact</TD>
						<TD>Head Count</TD>
					</TR>
					<TR>
						<TD><html:text property="pnr" size="6"></html:text></TD>
					    <TD><html:select property="crs">
							<html:option value="SABRE">SABRE</html:option>
							<html:option value="AMADEUS">AMADEUS</html:option>
						</html:select></TD>
					    <TD><html:select property="sales_type">
							<html:option value="0 - Regular">0 - Regular</html:option>
							<html:option value="1 - Online">1 - Online</html:option>
						</html:select></TD>
					    <TD><html:select property="ticket_type">
							<html:option value=""></html:option>
							<html:option value="ETICKET">ETICKET</html:option>
							<html:option value="PAPER">PAPER TICKET</html:option>
						</html:select></TD>
					    <TD><html:select property="ticket_issuer">
							<html:option value="NA"></html:option>
							<html:option value="SLT">Skylink</html:option>
							<html:option value="GT">Greaves</html:option>
							<html:option value="BTC">Belair</html:option>
							<html:option value="SKB">Skybird</html:option>
							<html:option value="HW">Harry World</html:option>
						</html:select></TD>
						<TD><html:text property="agent_name" size="10"></html:text></TD>
						<TD><html:text property="agent_name" size="20"></html:text></TD>
						<TD><html:text property="num_pax" size="1"></html:text></TD>
					</TR>
				</table>
			</TD></TR>
			<!-- spacer row -->
			<TR><TD>&nbsp;</TD></TR>
			<TR><TD>
				<!-- sales details -->
				<table>
					<TR colspan=11><TD>Sales Details</TD></TR>
					<TR>
						<TD>Item</TD>
						<TD>Ticket #/ Desc</TD>
						<TD>Last Name</TD>
						<TD>First Name</TD>
						<TD>Middle Name</TD>
						<TD>Title</TD>
						<TD>Fare</TD>
						<TD>Taxes</TD>
						<TD>Surcharge</TD>
						<TD>Total</TD>
						<TD>Currency</TD>
					</TR>
					<div id="pax1">
					<TR>
						<TD>1</TD>
						<TD><html:text property="pax1Description" size="10"></html:text></TD>
						<TD><html:text property="pax1Last_name" size="10"></html:text></TD>
						<TD><html:text property="pax1First_name" size="10"></html:text></TD>
						<TD><html:text property="pax1Middle_name" size="10"></html:text></TD>
						<TD><html:text property="pax1Title" size="10"></html:text></TD>
						<TD><html:text property="pax1Base" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax1Tax" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax1Surcharge" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax1Charge" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
					    <TD><html:select property="pax1Currency">
							<html:option value="USD">USD</html:option>
							<html:option value="INR">INR</html:option>
						</html:select></TD>
					</TR>
					</div>
					<div id="pax2" style="visibility:hidden;">
					<TR>
						<TD>2</TD>
						<TD><html:text property="pax2Description" size="10"></html:text></TD>
						<TD><html:text property="pax2Last_name" size="10"></html:text></TD>
						<TD><html:text property="pax2First_name" size="10"></html:text></TD>
						<TD><html:text property="pax2Middle_name" size="10"></html:text></TD>
						<TD><html:text property="pax2Title" size="10"></html:text></TD>
						<TD><html:text property="pax2Base" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax2Tax" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax2Surcharge" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax2Charge" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
					    <TD><html:select property="pax2Currency">
							<html:option value="USD">USD</html:option>
							<html:option value="INR">INR</html:option>
						</html:select></TD>
					</TR>
					</div>
					<div id="pax3" style="visibility:hidden;">
					<TR>
						<TD>3</TD>
						<TD><html:text property="pax3Description" size="10"></html:text></TD>
						<TD><html:text property="pax3Last_name" size="10"></html:text></TD>
						<TD><html:text property="pax3First_name" size="10"></html:text></TD>
						<TD><html:text property="pax3Middle_name" size="10"></html:text></TD>
						<TD><html:text property="pax3Title" size="10"></html:text></TD>
						<TD><html:text property="pax3Base" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax3Tax" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax3Surcharge" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax3Charge" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
					    <TD><html:select property="pax3Currency">
							<html:option value="USD">USD</html:option>
							<html:option value="INR">INR</html:option>
						</html:select></TD>
					</TR>
					</div>
					<div id="pax4" style="visibility:hidden;">
					<TR>
						<TD>4</TD>
						<TD><html:text property="pax4Description" size="10"></html:text></TD>
						<TD><html:text property="pax4Last_name" size="10"></html:text></TD>
						<TD><html:text property="pax4First_name" size="10"></html:text></TD>
						<TD><html:text property="pax4Middle_name" size="10"></html:text></TD>
						<TD><html:text property="pax4Title" size="10"></html:text></TD>
						<TD><html:text property="pax4Base" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax4Tax" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax4Surcharge" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax4Charge" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
					    <TD><html:select property="pax4Currency">
							<html:option value="USD">USD</html:option>
							<html:option value="INR">INR</html:option>
						</html:select></TD>
					</TR>
					</div>
					<div id="pax5" style="visibility:hidden;">
					<TR>
						<TD>5</TD>
						<TD><html:text property="pax5Description" size="10"></html:text></TD>
						<TD><html:text property="pax5Last_name" size="10"></html:text></TD>
						<TD><html:text property="pax5First_name" size="10"></html:text></TD>
						<TD><html:text property="pax5Middle_name" size="10"></html:text></TD>
						<TD><html:text property="pax5Title" size="10"></html:text></TD>
						<TD><html:text property="pax5Base" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax5Tax" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax5Surcharge" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
						<TD><html:text property="pax5Charge" size="6" onchange="javascript:updateTotal(this)"></html:text></TD>
					    <TD><html:select property="pax5Currency">
							<html:option value="USD">USD</html:option>
							<html:option value="INR">INR</html:option>
						</html:select></TD>
					</TR>
					</div>
					<TR>
						<TD colspan=6>Sales Totals:</TD>
						<TD><html:text property="totalBase" size="6"></html:text></TD>
						<TD><html:text property="totalTax" size="6"></html:text></TD>
						<TD><html:text property="totalSurcharge" size="6"></html:text></TD>
						<TD><html:text property="totalCharge" size="6"></html:text></TD>
					    <TD><html:select property="totalCurrency">
							<html:option value="USD">USD</html:option>
							<html:option value="INR">INR</html:option>
						</html:select></TD>
					</TR>
				</TABLE>
				<TABLE><TR>
					<TD>Form of payment</TD>
				    <TD><html:select property="form_of_payment">
						<html:option value="CC">Credit Card</html:option>
						<html:option value="CHECK">Check</html:option>
						<html:option value="CASH">Cash</html:option>
					</html:select></TD>
				</TR></TABLE>
				<TABLE valign="top"><TR>
				<TD>
				<div id="creditcard">
					<TABLE border=1>
						<TR>
							<TD colspan=2><B>CC DETAILS</B></TD>
						</TR>
						<TR>
							<TD>Last 4 digits of CARD</TD>
							<TD>Card Type</TD>
						</TR>
						<TR>
							<TD><html:text property="card_number" size="4" maxlength="4"></html:text></TD>
						    <TD><html:select property="card_type">
								<html:option value=""></html:option>
								<html:option value="VI">VISA</html:option>
								<html:option value="AM">AMEX</html:option>
								<html:option value="MC">MASTER</html:option>
								<html:option value="DI">DISCOVER</html:option>
								<html:option value="DN">DINERS</html:option>
							</html:select></TD>
						</TR>
					</TABLE>
				</div>
				</TD><TD>
				<div id="check">
					<TABLE border=1>
						<TR>
							<TD colspan=2><B>CHECK DEATILS</B></TD>
						</TR>
						<TR>
							<TD>Check Number</TD>
							<TD>Bank Name</TD>
						</TR>
						<TR>
							<TD><html:text property="check_number"></html:text></TD>
							<TD><html:text property="bank_name"></html:text></TD>
						</TR>
					</TABLE>
				</div>
				</TD><TD>
				<div id="cash">
					<TABLE border=1>
						<TR>
							<TD colspan=2><B>CASH DEATILS</B></TD>
						</TR>
						<TR>
							<TD>Received By</TD>
							<TD><html:text property="form_of_payment" size="10"></html:text></TD>
						</TR>
					</TABLE>
				</div>
				</TD></TR></TABLE>
			</TD></TR>

			<!-- spacer row -->
			<TR><TD>&nbsp;</TD></TR>

			<TR><TD>
				<table>
					<tr><td><B>Itinerary Link</B></td>
					<td>				
					<html:text property="itinerary_link"></html:text>
					</td></tr>
					<tr>
						<td>Depart Date (MM/dd/yyyy)</td>
						<td><html:text property="depart_date" size="10"></html:text>
						</td>
						<td>Return Date (MM/dd/yyyy)</td>
						<td><html:text property="return_date" size="10"></html:text></td>
						<td>Depart Airport</td>
						<td><html:text property="depart_airport" size="4"></html:text></td>
						<td>Arrive Airport</td>
						<td><html:text property="arrive_airport" size="4"></html:text></td>
						<td>Primary Airline</td>
						<td><html:text property="primary_airline" size="8"></html:text></td>
					</tr>
				</table>
			</TD></TR>

			<!-- spacer row -->
			<TR><TD>&nbsp;</TD></TR>

			<TR><TD>
			<!-- ITINERARY -->
			<table border=1>
				<tr><td colspan=14><B>ITINERARY</B></td></tr>
				<c:if test="${ticketFormBean.linePresent == 'true'}">
				<TR>
					<TD>SN</TD>
					<TD>Airline</TD>
					<TD>Flight</TD>
					<TD>Depart Date</TD>
					<TD>Depart Month</TD>
					<TD>Day</TD>
					<TD>Time</TD>
					<TD>Depart Airport</TD>
					<TD>Arrive Airport</TD>
					<TD>Arrive Date</TD>
					<TD>Arrive Month</TD>
					<TD>Day</TD>
					<TD>Time</TD>
					<TD>Airline confirmation code</TD>
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

			<TR><TD>
				<!-- COMMENTS TO PAX -->
				<table border=1>
					<tr><td><B>COMMENTS TO PASSENGER</B></td></tr>
					<tr><td>
					<html:textarea property="comments" rows="5" style="width:600px"></html:textarea>
					</td></tr>
				</table>
			</TD></TR>
			<TR><TD>
				<!-- NOTES -->
				<table border=1>
					<tr><td><B>INTERNAL NOTES</B></td></tr>
					<tr><td>
					<html:textarea property="notes" rows="4" style="width:600px"></html:textarea>
					</td></tr>
				</table>
			</TD></TR>
			<TR><TD>
				<table border=1>
					<tr><td><B>SABRE ITINERARY</B></td></tr>
					<tr><td>
					<html:textarea property="raw_text" rows="10" style="width:600px"></html:textarea>
					</td></tr>
				</table>
			</TD></TR>

			<!-- spacer row -->
			<TR><TD>&nbsp;</TD></TR>

			<TR><TD>
				<!-- terms row -->
				<table>
					<tr><td><B>TERMS</B></td></tr>
					<tr><td>Please inspect your tickets immediately. MyDreamFlight will not be responsible for errors if detected after 24 hours of delivery.</td></tr>
					<tr><td>Check-in for International flights at least 3 hours before departure.</td></tr>
					<tr><td>Check-in for domestic flights at least 2 hours before departure.</td></tr>
					<tr><td>All tickets are restricted and carry a cancellation penalty.</td></tr>
					<tr><td>A $25 service charge applies once tickets are returned.</td></tr>
					<tr><td>Other restrictions and liability limitations apply. A complete description is available on our website www.mydreamflight.com</td></tr>
					<tr><td>Please recheck the visa requirements with the airline/ consulate prior to departure.</td></tr>
					<tr><td>Please reconfirm your flights 72 hours before departure.</td></tr>
					<tr><td>For more information on your transit visa, trip planning, travel insurance and more please visit on our website www.mydreamflight.com</td></tr>
					<tr><td>We appreciate your business and hope to serve you again.</td></tr>
					<tr><td>Thank you for Choosing MYDREAMFLIGHT</td></tr>
					<tr><td>-providing wings to your dream</td></tr>
				</table>
			</TD></TR>

			</table>
			
		</TD></TR>
		</table>
		</html:form>
	</BODY>
</HTML>
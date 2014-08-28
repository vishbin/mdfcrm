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
	<TITLE>Contact Details</TITLE>
    <SCRIPT language="JavaScript">
    	var disableSaveButton = 'false';
        function setAction(choice, button) {
        	var form = button.form;
			form.actionn.value = choice;
			form.action = "contacts_action.do";
			if (choice == 'save') {
				if (disableSaveButton == 'true') {
					alert('Please wait while your request is being processed. If it takes too long, press the REFRESH button.');
					return false;
				} else {
		        	button.value= "Saving...";
					disableSaveButton = 'true';
				}
			} else if (choice == 'refresh') {
				disableSaveButton = 'false';
				alert('The status for Save button was successfully refreshed.');
				return false;
			}
            form.submit();
        }
    </SCRIPT>
</HEAD>
<BODY bgcolor="#9f9fff">
<H1 class="blue">MyDreamFlight Customer Details</H1>
	<table border=2>
		<tr><td>
		<iframe name="FRAME1" src='agents_action.do?actionn=agent_summary&agent_name=<c:out value="${user.agent_name}"/>' width=100% height=240px frameborder="1" scrolling="auto"></iframe>
		</td></tr>

		<tr><td>
		<b><a href="contacts.jsp">Click here to Search a Contact</a></b>
		<br/><br/>
		<b><a href="agents_action.do?actionn=agent_dashboard&agent_name=NONE">Click here to view all UnAssigned requests</a></b>
		<br/><br/>
		<c:if test="${user.agent_name != ''}">
			<b><a href="agents_action.do?actionn=agent_dashboard&agent_name=${user.agent_name}">Click here to view ${user.agent_name} 's DashBoard</a></b>
		</c:if>
		<br/><br/>
		<html:form action="/contacts_action.do" >
			<html:submit value="CREATE NEW" onclick="return setAction('add', this)"></html:submit>
			<html:submit value="SAVE" onclick="return setAction('save', this)"></html:submit>
			<html:submit value="DELETE" onclick="return setAction('softDelete', this)"></html:submit>
			<html:submit value="REFRESH" onclick="return setAction('refresh', this)"></html:submit>
		    <html:hidden property="actionn" value="ADD"/>
		    <html:hidden property="add_dttm"/>
		    <html:hidden property="update_dttm"/>
		    <html:hidden property="delete_dttm"/>
		    <html:hidden property="created_by"/>
		    <html:hidden property="updated_by"/>
		    <html:hidden property="previous_agent_assigned"/>
		    <html:hidden property="previous_status"/>
			<br/><br/>
			<B>AT A GLANCE</B>
			&nbsp;<B><a href="ticket_action.do?actionn=lookupByContact&contact_id=${contactFormBean.contact_id}" target="_blank">TICKETING INFORMATION</a></B>
			<TABLE>
			<TR>
				<!-- top column 1 -->
				<TD>
					<TABLE border=1 width=100%>
					<TR>
					<TD>
					    <TABLE width=100%>

						    <TR><TD>
						    <B>CONTACT INFO</B>
						    </TD></TR>

						    <TR><TD>
						    <table width=100%><tr>
						    	<td>
							    Contact ID <html:text styleClass="blue" disabled="true" property="contact_id" size="4"></html:text>
							    <html:hidden property="contact_id"/>
						    	</td>
							    <td>
							    Contact Source
							    <html:select property="contact_source">
									<html:option value=""></html:option>
									<html:option value="SULEKHA_LEAD">Sulekha Lead</html:option>
									<html:option value="AD_RESPONSE">Ad Response</html:option>
									<html:option value="REFERAL">Referal</html:option>
									<html:option value="EMAIL_REQUEST">Email Request</html:option>
									<html:option value="PHONE">Phone</html:option>
								</html:select>
						    	</td>
						    </tr></table>
						    </TD></TR>

						    <TR><TD>
						    <table width=100%><tr>
						    	<td>
						    	Contact Name
						    	</td><td>
						    	<html:text property="contact_name" size="40" maxlength="50"></html:text>
						    	</td>
						    </tr></table>
						    </TD></TR>

						    <TR><TD>
						    <table width=100%>
							    <tr>
							    <td>First</td>
							    <td>Middle</td>
							    <td>Last</td>
							    </tr>
							    <tr>
							    <td><html:text property="first_name" size="20" maxlength="20"></html:text></td>
							    <td><html:text property="middle_name" size="10" maxlength="20"></html:text></td>
							    <td><html:text property="last_name" size="20" maxlength="20"></html:text></td>
							    </tr>
							</table>
						    </TD></TR>

						    <TR><TD>
						    <table width=100%>
							    <tr>
							    <td>Mobile Phone</td>
							    <td>Work Phone</td>
							    <td>Home Phone</td>
							    </tr>
							    <tr>
							    <td><html:text property="phone_cell" size="10" maxlength="20"></html:text></td>
							    <td><html:text property="phone_work" size="10" maxlength="20"></html:text></td>
							    <td><html:text property="phone_home" size="10" maxlength="20"></html:text></td>
							    </tr>
							</table>
						    </TD></TR>

						    <TR><TD>
						    <table width=100%>
							    <tr>
							    <td>Home Email</td>
							    <td>Work Email</td>
							    </tr>
							    <tr>
							    <td><html:text property="email_home" size="15" maxlength="40"></html:text></td>
							    <td><html:text property="email_work" size="15" maxlength="40"></html:text></td>
							    </tr>
							</table>
						    </TD></TR>

						    <TR><TD>
						    <table><tr>
							    <td>
							    <table width=100%>
								    <tr><td><b>Mailing Address</b></td></tr>
								    <tr><td>Address 1 &nbsp;<html:text property="mailingAddress_line1" size="10"></html:text></td></tr>
								    <tr><td>Address 2 &nbsp;<html:text property="mailingAddress_line2" size="10"></html:text></td></tr>
								    <tr><td>Address 3 &nbsp;<html:text property="mailingAddress_line3" size="10"></html:text></td></tr>
								    <tr><td>City &nbsp;<html:text property="mailingAddress_city" size="10"></html:text> &nbsp; State &nbsp;<html:text property="mailingAddress_state" size="2"></html:text></td></tr>
								    <tr><td>Zip &nbsp;<html:text property="mailingAddress_zip" size="4"></html:text> &nbsp; Country &nbsp;<html:text property="mailingAddress_country" size="6"></html:text></td></tr>
							    </table>
							    </td>
							    <td>
							    <table width=100%>
								    <tr><td><b>Billing Address</b></td></tr>
								    <tr><td>Address 1 &nbsp;<html:text property="billingAddress_line1" size="10"></html:text></td></tr>
								    <tr><td>Address 2 &nbsp;<html:text property="billingAddress_line2" size="10"></html:text></td></tr>
								    <tr><td>Address 3 &nbsp;<html:text property="billingAddress_line3" size="10"></html:text></td></tr>
								    <tr><td>City &nbsp;<html:text property="billingAddress_city" size="10"></html:text> &nbsp; State &nbsp;<html:text property="billingAddress_state" size="2"></html:text></td></tr>
								    <tr><td>Zip &nbsp;<html:text property="billingAddress_zip" size="4"></html:text> &nbsp; Country &nbsp;<html:text property="billingAddress_country" size="6"></html:text></td></tr>
							    </table>
							    </td>
						    </tr></table>
						    </TD></TR>

			    		</TABLE>
			        </TD>
			        </TR>

					</TABLE>
				<TD>

				<!-- top column 2 -->
		        <TD width=500>
		        <TABLE border=1 width=100%>
		            <TR>
				    <TD>
					    <TABLE>
						    <TR><TD>
						    <B>STATUS INFO</B>
						    </TD></TR>
						    <TR><TD>
							    Tracking Number: &nbsp;
						    	<html:text property="tracking_number" size="15" maxlength="25"></html:text>
						    </TD></TR>
						    <TR>
						    <TD>
							    <TABLE width=100%><TR>
							    	<td>
								    Itinerary By: &nbsp;
								    <html:select property="itinerary_by">
									<html:option value="NONE">None</html:option>
									<html:option value="HEMANT">Hemant</html:option>
									<html:option value="KRISH">Krish</html:option>
									<html:option value="ANAND">Anand</html:option>
									<html:option value="SANTOSH">Santosh</html:option>
									<html:option value="SACHIN">Sachin</html:option>
									<html:option value="NAVEEN">Naveen</html:option>
									<html:option value="KAUSHIK">Kaushik</html:option>
									<html:option value="VISHAL">Vishal</html:option>
									</html:select>
									</td>
							    	<td>
								    Ticketed By: &nbsp;
								    <html:select property="ticketed_by">
									<html:option value="NONE">None</html:option>
									<html:option value="HEMANT">Hemant</html:option>
									<html:option value="KRISH">Krish</html:option>
									<html:option value="ANAND">Anand</html:option>
									<html:option value="SANTOSH">Santosh</html:option>
									<html:option value="SACHIN">Sachin</html:option>
									<html:option value="NAVEEN">Naveen</html:option>
									<html:option value="KAUSHIK">Kaushik</html:option>
									<html:option value="VISHAL">Vishal</html:option>
									</html:select>
									</td>
							    </TR></TABLE>
						    </TD>
						    </TR>
						    <TR>
						    <TD>
							    <TABLE width=100%><TR>
								    <TD>Assigned Agent</TD>
								    <TD><html:select property="agent_assigned">
								    <c:if test="${contactFormBean.agent_assigned == ''}">
										<html:option value="${user.agent_name}">${user.agent_name}</html:option>
									</c:if>
									<html:option value="NONE">None</html:option>
									<html:option value="SULEKHA_PROBLEM">Sulekha Problem</html:option>
									<html:option value="HEMANT">Hemant</html:option>
									<html:option value="KRISH">Krish</html:option>
									<html:option value="ANAND">Anand</html:option>
									<html:option value="SANTOSH">Santosh</html:option>
									<html:option value="SACHIN">Sachin</html:option>
									<html:option value="NAVEEN">Naveen</html:option>
									<html:option value="KAUSHIK">Kaushik</html:option>
									<html:option value="VISHAL">Vishal</html:option>
								    <!-- commenting for Status Reports There has to be agent assigned all the time to a customer  -->
								    <c:if test="${user.role == 'ADMIN'}">
										<html:option value="CLOSED">Closed</html:option>
									</c:if>
									</html:select></TD>
							    </TR></TABLE>
						    </TD>
						    </TR>

						    <TR>
						    <TD>
							    <TABLE width=100%><TR>
							    	<TD>Current Status</TD>
								    <TD><html:select property="status">
										<html:option value="REQUEST RECEIVED, TO GIVE FARE QUOTE">REQUEST RECEIVED, TO GIVE FARE QUOTE</html:option>
										<html:option value="REQUEST RECEIVED, TO PREPARE ITIN">REQUEST RECEIVED, TO PREPARE ITIN</html:option>
										<html:option value="FARE QUOTE GIVEN, FOLLOWUP TO BE DONE">FARE QUOTE GIVEN, FOLLOWUP TO BE DONE</html:option>
										<html:option value="DATE CHANGE REQUESTED, TO PREPARE ITIN">DATE CHANGE REQUESTED, TO PREPARE ITIN</html:option>
										<html:option value="ITINERARY GIVEN, FARES PENDING">ITINERARY GIVEN, FARES PENDING</html:option>
										<html:option value="ITINERARY GIVEN, FOLLOWUP TO BE DONE">ITINERARY GIVEN, FOLLOWUP TO BE DONE</html:option>
										<html:option value="FOLLOWUP TO BE DONE">FOLLOWUP TO BE DONE</html:option>
										<html:option value="CALLED CUSTOMER, VOICEMAIL LEFT">CALLED CUSTOMER, VOICEMAIL LEFT</html:option>
										<html:option value="PHONE+EMAIL FOLLOWUP DONE, NO RESPONSE">PHONE+EMAIL FOLLOWUP DONE, NO RESPONSE</html:option>
										<html:option value="CUSTOMER SAID, WILL CALL LATER">CUSTOMER SAID, WILL CALL LATER</html:option>
										<html:option value="CUSTOMERS PLAN CANCELED OR POSTPONED">CUSTOMER'S PLAN CANCELED OR POSTPONED</html:option>
										<html:option value="CUSTOMER PURCAHSED TICKETS ELSEWHERE">CUSTOMER PURCAHSED TICKETS ELSEWHERE</html:option>
										<html:option value="TICKET ISSUED, TO SEND DOCS">TICKET ISSUED, TO SEND DOCS</html:option>
										<html:option value="CUSTOMER LOST">CUSTOMER LOST</html:option>
										<html:option value="DOCUMENT EMAILED, TO FEDEX DOCS">DOCUMENT EMAILED, TO FEDEX DOCS</html:option>
										<html:option value="FEDEX SENT, TO CLOSE">FEDEX SENT, TO CLOSE</html:option>
										<html:option value="OTHER">OTHER</html:option>
									    <c:if test="${user.role == 'ADMIN'}">
											<html:option value="CLOSED">Closed, DO NOT EDIT</html:option>
										</c:if>
									</html:select></TD>
							    </TR></TABLE>
						    </TD>
							</TR>

					        <TR>
					        <TD>
							    <TABLE width=100%>
							    <TR><TD>
							    <B>NOTES</B><BR/>
							    <html:textarea property="notes" rows="4" style="width:100%"></html:textarea>
							    </TD></TR>
				    			</TABLE>
					        </TD>
					        </TR>

					        <TR>
					        <TD>
							    <TABLE width=100%>
							    <TR><TD>
							    <B>STATUS HISTORY</b><BR/>
							    <html:textarea  disabled="true" property="status_history" rows="5" style="width:100%"></html:textarea>
							    <html:hidden property="status_history"/>
							    </TD></TR>
				    			</TABLE>
					        </TD>
					        </TR>

		                </TABLE>
		            </TD>
	            	</TR>
	        	</TABLE>
	        	</TD> <!-- col 2 ends -->
	        </TR>
	        </TABLE>
			<br/>
			<html:submit value="CREATE NEW" onclick="return setAction('add', this)"></html:submit>
			<html:submit value="SAVE" onclick="return setAction('save', this)"></html:submit>
			<html:submit value="DELETE" onclick="return setAction('softDelete', this)"></html:submit>
			<html:submit value="REFRESH" onclick="return setAction('refresh', this)"></html:submit>
	    </html:form>
	    </td></tr>
    </table>
</BODY></HTML>
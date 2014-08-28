<!--
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*" %>
<%@ page import="mdf.forms.*" %>
-->
<LINK HREF="css/mdfstyles.css" TYPE="text/css" REL="stylesheet" />
<HTML>
<HEAD>
	<TITLE>Call Details</TITLE>
    <SCRIPT language="JavaScript">
    	var backup_form;
    	function validate_form() {
    		form = document.forms[0];
    		
	    	if (document.forms[0].actionn.value == 'save') {
		    	var dirty = false;
	        	dirty = checkdirty(form);
	        	if (dirty == true)
	        		return false;
			}
			return true;
    	}
        function setAction(choice, form) {
			form.actionn.value = choice;
			form.action = "call_action.do";
        	var result = validate_form();
        	alert (result);
        	if (result == false) {
        		return false;
        	}
            form.submit();
        }
        function setContact(contactID, form) {
        	alert(contactID);
        	form.contactForm.contact_name = "JIGNA1";
        	form.contactForm.first_name = "JIGNA2";
        	form.contactForm.last_name = "JIGNA3";
        	alert('kaushik11');
        	alert(form.contactForm.last_name);
        }
        function checkdirty() {
        	var dirty = false;
        	dirty = checkDirtyContact();
        	if (dirty == true)
	        	return dirty;
	        else {
	        	return dirty;
	        }
        }
        function checkDirtyContact() {
	        var dirty = false;
	        if ("${callFormBean.contactForm.first_name}" != document.forms['contact_form'].first_name.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.last_name}" != document.forms['contact_form'].last_name.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.middle_name}" != document.forms['contact_form'].middle_name.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.phone_work}" != document.forms['contact_form'].phone_work.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.phone_cell}" != document.forms['contact_form'].phone_cell.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.phone_home}" != document.forms['contact_form'].phone_home.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.email_work}" != document.forms['contact_form'].email_work.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.email_home}" != document.forms['contact_form'].email_home.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.address_line1_home}" != document.forms['contact_form'].address_line1_home.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.address_line2_home}" != document.forms['contact_form'].address_line2_home.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.address_line3_home}" != document.forms['contact_form'].address_line3_home.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.city_home}" != document.forms['contact_form'].city_home.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.state_home}" != document.forms['contact_form'].state_home.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.zip_home}" != document.forms['contact_form'].zip_home.value) {
	        	dirty= true;
	       	} else if ("${callFormBean.contactForm.country_home}" != document.forms['contact_form'].country_home.value) {
	        	dirty= true;
	       	}
	       	
	       	if (dirty == true) {
	       		alert ("Unsaved changes in contact. Save or Discard before proceeding. !");
	       		return dirty;
	       	} else return dirty;
			
        }
        function backup() {
        	alert('backup');
	        alert("${callFormBean.contactForm.first_name}");
	        alert(document.forms['contact_form'].first_name.value);
//   	        backup_form=document.forms[0].clone();
//			alert(backup_form);        
        }
    </SCRIPT>
</HEAD>
<BODY>
<H1 class="blue">Call Details</H1>
	    <table border=1>
	    <tr border=1>
		    <td>CONTACT</td>
		    <td>TASKS</td>
		    <td>CALLS</td>
		    <td>REQUESTS</td>
		    <td>BOOKINGS</td>
		    <td>DOCUMENTS</td>
		    <td>ETC</td>
		    <td>ETC</td>
	    </tr>
	    </table>

		<br/><br/>
		<B>AT A GLANCE CALL
		<TABLE border=2>
		<TR>
		<!-- this is column 1 of the page -->
		<TD width=600>
			<TABLE border=1 width=100%>
			    <!-- this is call info row -->
			    <TR>
    			<TD>
		    	<html:form action="/call_action.do" onsubmit="return validate_form ();">
		            <html:submit value="NEW CALL" onclick="javascript:setAction('add', this.form)"></html:submit>
		            <html:submit value="SAVE" onclick="javascript:setAction('save', this.form)"></html:submit>
		            <html:submit value="DELETE" onclick="javascript:setAction('delete', this.form)"></html:submit>
<!--
	                <html:hidden property="ui_selectedContact" value="${ui_selectedContact}"/>
	                <html:hidden property="deleted" value="${deleted}"/>
	                <html:hidden property="insert_key" value="${insert_key}"/>
	                <html:hidden property="user" value="${user}"/>
-->	    
            	    
	                <html:hidden property="actionn" value="ADD"/>
                    <TABLE>
    			        <TR>
	    		        <TD colspan =3><B>CALL INFO</TD>
		        	    </TR>
			            <TR>
			            <TD colspan=3>
			            Call ID <html:text property="call_id" size="4"></html:text>
			            </TD></TR>

			            <TR>
			            <TD><html:select property="channel">
					        <html:option value="PHONE">Phone</html:option>
					        <html:option value="EMAIL">Email</html:option>
				        </html:select></TD>
				        <td>Phone:<html:text property="number" size="10" ></html:text></td>
				        <td>Email:<html:text property="email" size="20"></html:text></td>
				        </TR>
			            <TR>
			            <TD>CHANNEL</TD>
				        <td><html:submit value="LOOKUP PHONE" onclick="javascript:setAction('lookupContactAndRequest', this.form)"></html:submit></td>
				        <td><html:submit value="LOOKUP EMAIL" onclick="javascript:setAction('lookupContactAndRequest', this.form)"></html:submit></td>
				        </TR>

			            <TR>
			            <TD><html:text property="user" size="10"></html:text></TD>
				        <td><html:select property="call_type">
					        <html:option value="INBOUND">Inbound</html:option>
					        <html:option value="OUTBOUND">Outbound</html:option>
				        </html:select></td>
				        <td><html:text property="date_time" size="20"></html:text></td>
				        </TR>

			            <TR>
			            <TD>Contact:</TD>
				        <td><html:text property="ui_name" size="20"></html:text></td>
				        <td><html:submit value="LOOKUP CONTACT" onclick="javascript:setAction('lookupContactAndRequest', this.form)"></html:submit></td>
				        </TR>

    		    <!-- this is notes row, lets figure later -->
					    <TR>
					    <TD COLSPAN=3>
					        <TABLE>
					        <TR><TD>
					        <B>CALL NOTES</B>
					        <BR>
					        </TD></TR>
				            <TR>
				            <TD>	
					            <html:textarea property="notes" rows="4"></html:textarea>
				            </TD>
				            </TR>
					        </TABLE>
			            </TD>
			            </TR>

				    </TABLE>
    			</TD>
	    		</TR>
	    		<!-- this is contact list row -->
		    	<TR>
			    <TD>
				<c:if test="${callFormBean.contact_id < 0 }">
				    <TABLE id="listContacts">
				    <TR>
				    <TD><B>CONTACT LIST</TD>
    				</TR>
					
					<TR>
					<TD><html:radio property="ui_selectedContact" value="${callFormBean.contact_id}" onchange="html:javascript:alert('kaushik1');">
					  	<c:url var="contactUrl" scope="page" value="/contacts_action.do">
				        	<c:param name="actionn" value="add"/>
				         	<c:param name="contact_id" value="0"/>
				     	</c:url>
						<a href="${contactUrl}" target="_blank">
							ADD NEW CONTACT DETAILS
						</a>
						</html:radio>
				    </TD></TR>

					<c:forEach items="${callContactList}" var="kcontact">
					<TR>
					<TD><html:radio property="ui_selectedContact" value="${kcontact.contact_id}" onchange="html:javascript:setAction('setContact', this.form);">
					  	<c:url var="contactUrl" scope="page" value="/contacts_action.do">
				        	<c:param name="actionn" value="edit"/>
				         	<c:param name="contact_id" value="${kcontact.contact_id}"/>
				     	</c:url>
						<a href="${contactUrl}" target="_blank">
							<c:out value="${kcontact.ui_name}"/>
							<br><c:out value="${kcontact.ui_number}"/>
							<br><c:out value="${kcontact.ui_email}"/>
						</a>
						</html:radio>
				    </TD></TR>
				    </c:forEach>
				    </TABLE>
			    </c:if>
    			</html:form>
			    </TD>
			    </TR>

                <!-- this is contact info form -->
			    <TR>
			    <TD>				    
			    <form name="contact_form" action="contacts_action.do" method="post">
				    <TABLE>
			            <TR><TD>
			            <TABLE><TR>
			            <TD><b>CONTACT INFO</TD>
			            <TD><input type="hidden" name="actionn" value="saveContactForCall"/></TD>
			            <TD><input type="submit" value="save"/></TD>
			            <TD><input type="submit" value="reset"/></TD>
			            </TR></TABLE>
			            </TD></TR>
    			    
			            <TR><TD>
			            <TABLE><TR>
				        <TD>Contact ID</TD>

			            <TD><input type="text" name="contact_id" value="${callFormBean.contactForm.contact_id}"/></TD>
			            </TR></TABLE>
			            </TD></TR>
    			    
				        <TR><TD>
				            <TABLE><TR>
				            <TD><input type="text" name="first_name" value="${callFormBean.contactForm.first_name}"/></TD>
			                <TD><input type="text" name="middle_name" value="${callFormBean.contactForm.middle_name}"/></TD>
			                <TD><input type="text" name="last_name" value="${callFormBean.contactForm.last_name}"/></TD>
			                </TR>
			                <TR>
				            <TD>First</TD>
			                <TD>Middle</TD>
			                <TD>Last</TD>
			                </TR></TABLE>
			            </TD></TR>
    			    
				        <TR><TD>
				            <TABLE><TR>
				            <TD><input type="text" name="phone_work" value="${callFormBean.contactForm.phone_work}"/></TD>
			                <TD><input type="text" name="phone_cell" value="${callFormBean.contactForm.phone_cell}"/></TD>
			                <TD><input type="text" name="phone_home" value="${callFormBean.contactForm.phone_home}"/></TD>
			                </TR><TR>
				            <TD>Work</TD>
			                <TD>Cell</TD>
			                <TD>Home</TD>
			                </TR></TABLE>
			            </TD></TR>
    			    
				        <TR><TD>
				            <TABLE><TR>
			                <TD><input type="text" name="email_work" value="${callFormBean.contactForm.email_work}"></TD>
			                <TD><input type="text" name="email_home" value="${callFormBean.contactForm.email_home}"></TD>
			                </TR><TR>
			                <TD>Email work</TD>
			                <TD>Email home</TD>
			                </TR></TABLE>
			            </TD></TR>

                        <TR><TD>
	                        <TABLE><TR>
		                        <TD><input type="text" name="address_line1_home" value="${callFormBean.contactForm.address_line1_home}"></TD>
		                        <TD><input type="text" name="address_line2_home" value="${callFormBean.contactForm.address_line2_home}"></TD>
		                        <TD><input type="text" name="address_line3_home" value="${callFormBean.contactForm.address_line3_home}"></TD>
	                        </TR><TR>
		                        <TD>Addr1</TD>
		                        <TD>Addr2</TD>
		                        <TD>Addr3</TD>
		                    </TR><TR>    
		                        <TD><input type="text" name="city_home" value="${callFormBean.contactForm.city_home}"></TD>
		                        <TD><input type="text" name="state_home" value="${callFormBean.contactForm.state_home}"></TD>
		                        <TD><input type="text" name="zip_home" value="${callFormBean.contactForm.zip_home}"></TD>
		                        <TD><input type="text" name="country_home" value="${callFormBean.contactForm.country_home}"></TD>
		                    </TR><TR>
		                        <TD>City</TD>
		                        <TD>State</TD>
		                        <TD>Zip</TD>
		                        <TD>Country</TD>
	                        </TR></TABLE>
                        </TD></TR>

			        </TABLE>
			    </form>
			    </TD>
			    </TR>

			</TABLE>
		</TD>
		
        <!-- this is column 2 on page calls page -->
	    <TD width=600>
	        <TABLE border=2 width=100%>
	            <!-- this is row 0 for test -->
	            <TR>
	            <TD>hello
                </TD>
                </TR>
                
	            <!-- this is row 1 for request list -->
	            <TR>
	            <TD>
				<c:if test="${callFormBean.request_id < 0 }">
				    <TABLE id="listRequests">
				    <TR>
				    <TD><B>REQUEST DETAILS</TD>
				    </TR>
				
					<TR>
					<TD><html:radio property="ui_selectedRequest" value="${callFormBean.request_id}" onchange="html:javascript:alert('kaushik2');">
					  	<c:url var="requestUrl" scope="page" value="/requests_action.do">
				        	<c:param name="actionn" value="add"/>
				         	<c:param name="request_id" value="0"/>
				     	</c:url>
						<a href="${requestUrl}" target="_blank">
							ADD NEW REQUEST DETAILS
						</a>
						</html:radio>
				    </TD></TR>

					<c:forEach items="${callRequestList}" var="krequest">
					<TR>
					<TD><html:radio property="ui_selectedRequest" value="${krequest.request_id}" onchange="html:javascript:setAction('setRequest', this.form);">
					  	<c:url var="requestUrl" scope="page" value="/requests_action.do">
				        	<c:param name="actionn" value="edit"/>
				         	<c:param name="request_id" value="${krequest.request_id}"/>
				     	</c:url>
						<a href="${requestUrl}" target="_blank">
							<c:out value="${krequest.request_id}"/>
							<br><c:out value="${krequest.created_by}"/>
							<br><c:out value="${krequest.add_dttm}"/>
							<br><c:out value="${krequest.num_itinerary}"/>
						</a>
						</html:radio>
				    </TD></TR>
				    </c:forEach>
				    </TABLE>
				</c:if>
                </TD>
                </TR>
				
				<!-- this is row 2 for request info -->	
				<TR>
				<TD>		    
			    <form name="request_form" action="request_action.do">
				    <TABLE>
			        <TR><TD>
			            <TABLE><TR>
			            <TD><b>REQUEST INFO</TD>
			            <TD><input type="hidden" name="actionn" value="save"/></TD>
			            <TD><input type="submit" value="save"/></TD>
			            <TD><input type="submit" value="reset"/></TD>
			            </TR></TABLE>
			        </TD></TR>
			    
			        <TR><TD>
			            <TABLE><TR>
				        <TD>Request ID</TD>

			            <TD><input type="text" name="request_id" value="${callFormBean.requestForm.request_id}"/></TD>
			            </TR></TABLE>
			        </TD></TR>
			    
    				<TR><TD>
				        <TABLE><TR>
				        <TD><input type="text" name="depart_date" value="${callFormBean.requestForm.depart_date}"/></TD>
				        <TD><input type="text" name="return_date" value="${callFormBean.requestForm.return_date}"/></TD>
			            </TR><TR>
				        <TD>Depart date</TD>
			            <TD>Return date</TD>
			            </TR></TABLE>
	    		    </TD></TR>
			    
				    <TR><TD>
				        <TABLE><TR>
				        <TD><input type="text" name="depart_airport" value="${callFormBean.requestForm.depart_airport}"/></TD>
				        <TD><input type="text" name="arrive_airport" value="${callFormBean.requestForm.arrive_airport}"/></TD>
			            </TR><TR>
				        <TD>Depart airport</TD>
			            <TD>Arrive airport</TD>
			            </TR></TABLE>
			        </TD></TR>
			    
				    <TR><TD>
				        <TABLE><TR>
				        <TD><input type="text" name="primary_airline" value="${callFormBean.requestForm.primary_airline}"/></TD>
			            </TR><TR>
				        <TD>Primary Airline</TD>
			            </TR></TABLE>
			        </TD></TR>
			    
				    <TR><TD>
				        <TABLE><TR>
				        <TD><input type="textarea" name="notes" value="${callFormBean.requestForm.notes}"/></TD>
			            </TR><TR>
			            <TD>Notes</TD>
			            </TR></TABLE>
			        </TD></TR>
			    
				    <TR><TD>
				        <TABLE><TR>
				        <TD>PAX 1</TD>
				        <TD><input type="text" name="pax1_first_name" value="${callFormBean.requestForm.pax1_first_name}"/></TD>
			            <TD><input type="text" name="pax1_middle_name" value="${callFormBean.requestForm.pax1_middle_name}"/></TD>
			            <TD><input type="text" name="pax1_last_name" value="${callFormBean.requestForm.pax1_last_name}"/></TD>
			            <TD><input type="text" name="pax1_title" value="${callFormBean.requestForm.pax1_title}"/></TD>
			            <TD><input type="text" name="pax1_age" value="${callFormBean.requestForm.pax1_age}"/></TD>
			            </TR><TR>
				        <TD></TD>
				        <TD>First</TD>
			            <TD>Middle</TD>
			            <TD>Last</TD>
			            <TD>Title</TD>
			            <TD>Age</TD>
			            </TR></TABLE>
			        </TD></TR>
			    
				    <TR><TD>
				        <TABLE><TR>
				        <TD>PAX 2</TD>
				        <TD><input type="text" name="pax2_first_name" value="${callFormBean.requestForm.pax2_first_name}"/></TD>
			            <TD><input type="text" name="pax2_middle_name" value="${callFormBean.requestForm.pax2_middle_name}"/></TD>
			            <TD><input type="text" name="pax2_last_name" value="${callFormBean.requestForm.pax2_last_name}"/></TD>
			            <TD><input type="text" name="pax2_title" value="${callFormBean.requestForm.pax2_title}"/></TD>
			            <TD><input type="text" name="pax2_age" value="${callFormBean.requestForm.pax2_age}"/></TD>
			            </TR><TR>
				        <TD></TD>
				        <TD>First</TD>
			            <TD>Middle</TD>
			            <TD>Last</TD>
			            <TD>Title</TD>
			            <TD>Age</TD>
			            </TR></TABLE>
			        </TD></TR>
			    
				    <TR><TD>
				        <TABLE><TR>
				        <TD>PAX 3</TD>
				        <TD><input type="text" name="pax3_first_name" value="${callFormBean.requestForm.pax3_first_name}"/></TD>
			            <TD><input type="text" name="pax3_middle_name" value="${callFormBean.requestForm.pax3_middle_name}"/></TD>
			            <TD><input type="text" name="pax3_last_name" value="${callFormBean.requestForm.pax3_last_name}"/></TD>
			            <TD><input type="text" name="pax3_title" value="${callFormBean.requestForm.pax3_title}"/></TD>
			            <TD><input type="text" name="pax2_age" value="${callFormBean.requestForm.pax3_age}"/></TD>
			            </TR><TR>
				        <TD></TD>
				        <TD>First</TD>
			            <TD>Middle</TD>
			            <TD>Last</TD>
			            <TD>Title</TD>
			            <TD>Age</TD>
			            </TR></TABLE>
			        </TD></TR>
			    
				    <TR><TD>
				        <TABLE><TR>
				        <TD>PAX 4</TD>
				        <TD><input type="text" name="pax4_first_name" value="${callFormBean.requestForm.pax4_first_name}"/></TD>
			            <TD><input type="text" name="pax4_middle_name" value="${callFormBean.requestForm.pax4_middle_name}"/></TD>
			            <TD><input type="text" name="pax4_last_name" value="${callFormBean.requestForm.pax4_last_name}"/></TD>
			            <TD><input type="text" name="pax4_title" value="${callFormBean.requestForm.pax4_title}"/></TD>
			            <TD><input type="text" name="pax4_age" value="${callFormBean.requestForm.pax4_age}"/></TD>
			            </TR><TR>
				        <TD></TD>
				        <TD>First</TD>
			            <TD>Middle</TD>
			            <TD>Last</TD>
			            <TD>Title</TD>
			            <TD>Age</TD>
			            </TR></TABLE>
			        </TD></TR>
			    
				    <TR><TD>
				        <TABLE><TR>
			            <TD><input type="text" name="email_work" value="${callFormBean.contactForm.email_work}"></TD>
			            <TD><input type="text" name="email_home" value="${callFormBean.contactForm.email_home}"></TD>
			            </TR><TR>
			            <TD>Email work</TD>
			            <TD>Email home</TD>
			            </TR></TABLE>
			        </TD></TR>
			    
				    <TR><TD>
				        <TABLE><TR>
			            <TD><input type="text" name="address_line1_home" value="${callFormBean.contactForm.address_line1_home}"></TD>
			            <TD><input type="text" name="address_line2_home" value="${callFormBean.contactForm.address_line2_home}"></TD>
			            <TD><input type="text" name="address_line3_home" value="${callFormBean.contactForm.address_line3_home}"></TD>
			            <TD><input type="text" name="city_home" value="${callFormBean.contactForm.city_home}"></TD>
			            <TD><input type="text" name="state_home" value="${callFormBean.contactForm.state_home}"></TD>
			            <TD><input type="text" name="zip_home" value="${callFormBean.contactForm.zip_home}"></TD>
			            <TD><input type="text" name="country_home" value="${callFormBean.contactForm.country_home}"></TD>
			            </TR><TR>
			            <TD>Addr1</TD>
			            <TD>Addr2</TD>
			            <TD>Addr3</TD>
			            <TD>City</TD>
			            <TD>State</TD>
			            <TD>Zip</TD>
			            <TD>Country</TD>
			            </TR></TABLE>
			        </TD></TR>
			    
				    <TR><TD>
				        <TABLE><TR>
				        <TD><input type="text" name="num_calls" value="${callFormBean.requestForm.num_calls}"/></TD>
				        <TD><input type="text" name="num_itinerary" value="${callFormBean.requestForm.num_itinerary}"/></TD>
				        <TD><input type="text" name="num_tickets" value="${callFormBean.requestForm.num_tickets}"/></TD>
			            </TR><TR>
				        <TD>Total Calls</TD>
			            <TD>Total Itineraries</TD>
			            <TD>Total Tickets</TD>
			            </TR></TABLE>
			        </TD></TR>
			        
			        </TABLE>
			    </form>
	        
	            </TD>
	            </TR>
	        </TABLE>
	    </TD>
	    </TR>    
		</TABLE>
						
</BODY></HTML>
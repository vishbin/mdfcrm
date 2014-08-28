<!--
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html" %>

<%@ page import="java.util.*" %>
<%@ page import="mdf.forms.*" %>
<LINK HREF="mdfstyles.css" TYPE="text/css" REL="stylesheet" />
-->
<HTML>
<HEAD>
	<TITLE>Contact Details</TITLE>
    <SCRIPT language="JavaScript">
        function setAction(choice) {
   	        var f= document.forms[0];
			f.action.value = choice;
			f.action = "contacts_action.do";
            f.submit();
        }
    </SCRIPT>
</HEAD>
<BODY BGCOLOR="#FDF5E6">
<H1 class="blue">Contact Details</H1>
<c:out value="${contactFormBean.first_name}"/>
<c:out value="${contactFormBean.last_name}"/>
<bean:write name="contactFormBean" property="last_name"></bean:write>
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
	<html:form action="/contacts_action.do" >
		<html:submit value="add" onclick="javascript:setAction('add')"></html:submit>
		<html:submit value="save" onclick="javascript:setAction('save')"></html:submit>
		<html:submit value="delete" onclick="javascript:setAction('delete')"></html:submit>
	    <html:hidden property="action" value="add"/>
		<br/><br/>
		<B>AT A GLANCE
		<TABLE width=800 border=2>
		<TR>
		<TD width=600>
			<TABLE border=1 width=100%>
			<TR>
			<TD>
			    <TABLE>

			    <TR><TD>
			    <B>CONTACT INFO
			    </TD></TR>
			    <TR><TD>
			    Contact ID <html:text property="contact_id" size="4"></html:text>
			    </TD></TR>

			    <TR><TD>
			    Contact Name <html:text property="contact_name" size="40"></html:text>
			    </TD></TR>

			    <TR><TD>
			    <table><tr>		    
			    <td><html:text property="first_name" size="20"></html:text></td>
			    <td><html:text property="middle_name" size="10"></html:text></td>
			    <td><html:text property="last_name" size="20"></html:text></td>
			    </tr><tr>
			    <td>First</td>
			    <td>Middle</td>
			    <td>Last</td>
			    </tr></table>
			    </TD></TR>

			    <TR><TD>
			    <table><tr>		    
			    <td><html:text property="phone_cell" size="10"></html:text></td>
			    <td><html:text property="phone_work" size="10"></html:text></td>
			    <td><html:text property="phone_home" size="10"></html:text></td>
			    </tr><tr>
			    <td>Mobile Phone</td>
			    <td>Work Phone</td>
			    <td>Home Phone</td>
			    </tr></table>
			    </TD></TR>
			    
			    <TR><TD>
			    <table><tr>		    
			    <td><html:text property="email_home" size="10"></html:text></td>
			    <td><html:text property="email_work" size="10"></html:text></td>
			    </tr><tr>
			    <td>Home Email</td>
			    <td>Work Email</td>
			    </tr></table>
			    </TD></TR>
			    
			    <TR><TD>
			    <table><tr><td>
			    <table>
			    <tr><td><b>Mailing Address</td></tr>
			    <tr><td>Address 1 &nbsp;<html:text property="address_line1_home" size="10"></html:text></td></tr>
			    <tr><td>Address 2 &nbsp;<html:text property="address_line2_home" size="10"></html:text></td></tr>
			    <tr><td>Address 3 &nbsp;<html:text property="address_line3_home" size="10"></html:text></td></tr>
			    <tr><td>City &nbsp;<html:text property="city_home" size="10"></html:text> &nbsp; State &nbsp;<html:text property="state_home" size="2"></html:text></td></tr>
			    <tr><td>Zip &nbsp;<html:text property="zip_home" size="4"></html:text> &nbsp; Country &nbsp;<html:text property="country_home" size="10"></html:text></td></tr>
			    </table>
			    </td><td>
			    <table>
			    <tr><td><b>Billing Address</td></tr>
			    <tr><td>Address 1 &nbsp;<html:text property="address_line1_work" size="10"></html:text></td></tr>
			    <tr><td>Address 2 &nbsp;<html:text property="address_line2_work" size="10"></html:text></td></tr>
			    <tr><td>Address 3 &nbsp;<html:text property="address_line3_work" size="10"></html:text></td></tr>
			    <tr><td>City &nbsp;<html:text property="city_work" size="10"></html:text> &nbsp; State &nbsp;<html:text property="state_work" size="2"></html:text></td></tr>
			    <tr><td>Zip &nbsp;<html:text property="zip_work" size="4"></html:text> &nbsp; Country &nbsp;<html:text property="country_work" size="10"></html:text></td></tr>
			    </table>
			    </td></tr></table>
			    </TD></TR>
			    
    			</TABLE>
	        </TD>
	        </TR>
	        
	        <TR>
	        <TD>
			    <TABLE>

			    <TR><TD>
			    <B>NOTES<BR>
			    <html:textarea property="notes" rows="4"></html:textarea>
			    </TD></TR>
			    
    			</TABLE>
	        </TD>
	        </TR>
	        
	        <TR>
	        <TD>
			    <TABLE>
			    
			    <TR><TD>
	      	        <c:url var="contactItineraryUrl0" scope="page" value="/contacts_action.do">
	        	        <c:param name="action" value="edit"/>
	        	        <c:param name="ui_tab" value="itinerary"/>
	         	        <c:param name="ui_contextid" value="0"/>
	         	        <c:param name="contact_id" value="${kcontact.contact_id}"/>
	     	        </c:url>
			        <a href="${contactItineraryUrl0}">
				        ITINERARY HISTORY &NBSP;<c:out value="${contactFormBean.num_itineraries}"/>
			        </a>
			    </TD></TR>
			    
			    <TR><TD>
		            <c:forEach items="${contactFormBean.itinerariesList}" var="kitinerary">
	      	            <c:url var="contactItineraryUrl" scope="page" value="/contacts_action.do">
	        	            <c:param name="action" value="edit"/>
	        	            <c:param name="ui_tab" value="itinerary"/>
	         	            <c:param name="ui_contextid" value="${kitinerary.itinerary_id}"/>
	         	            <c:param name="contact_id" value="${kcontact.contact_id}"/>
	     	            </c:url>
			            <a href="${contactItineraryUrl}">
				            <c:out value="${kitinerary.pnr}"/> - <c:out value="${kitinerary.depart_date}"/> - <c:out value="${kitinerary.return_date}"/> - <c:out value="${kitinerary.depart_airport}"/> - <c:out value="${kitinerary.arrive_airport}"/> - <c:out value="${kitinerary.primary_airline}"/>
			            </a><br/>
	                </c:forEach>
			    </TD></TR>
			    
    			</TABLE>
	        </TD>
	        </TR>
	        
            <!-- kaushik todo add referal history as above -->
            <!-- kaushik todo add ticket history as above -->
		</TABLE>
		<TD>
		
		<!-- top column 2 -->
        <TD width=400>
        <TABLE border=1 width=100%>
            <!-- kaushik todo add call history as above -->
            <!-- kaushik todo add pax info as above -->

            <!-- kaushik todo add status as above -->
            <!-- kaushik todo add actions as above -->
            <!-- kaushik todo add task history as above -->

            <TR>
		    <TD>
                    
			    <TABLE>

			    <TR><TD>
			    <B>CONTACT INFO
			    </TD></TR>
			    <TR><TD>
			    Contact ID <html:text property="contact_id"></html:text>
			    </TD></TR>
                </TABLE>
            </TD>
            </TR>
        </TABLE>
				
    </html:form>
</BODY></HTML>
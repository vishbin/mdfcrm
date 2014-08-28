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
	<TITLE>Ticket List</TITLE>
    <SCRIPT language="JavaScript">
        function setAction(choice, form) {
			form.actionn.value = choice;
			form.action = "ticket_action.do";
            form.submit();
        }
    </SCRIPT>
</HEAD>
<BODY>
<H1 class="blue">MyDreamFlight Ticket List</H1>
	<table border=2>
		<tr><td>
		<html:form action="/ticket_action.do" >
			<html:submit value="CREATE NEW" onclick="javascript:setAction('add', this.form)"></html:submit>
		    <html:hidden property="actionn" value="ADD"/>
		    <html:hidden property="add_dttm"/>
		    <html:hidden property="update_dttm"/>
		    <html:hidden property="delete_dttm"/>
		    <html:hidden property="added_by"/>
		    <html:hidden property="updated_by"/>

		    <html:hidden property="contact_id"/>
			<br/><br/>
			<B>TICKET LIST FOR CONTACT</B>
			<TABLE>
			<TR>
				<TD>
					<TABLE border=1 width=100%>
					<TR>
					<TD>
						<br/>CONTACT ID ${ticketFormBean.contact_id} HAS FOLLOWING TICKET RECORDS<br/>
						<c:forEach items="${ticketList}" var="kticket">
					      	<c:url var="ticketUrl" scope="page" value="/ticket_action.do">
					        	<c:param name="actionn" value="edit"/>
					         	<c:param name="ticket_id" value="${kticket.ticket_id}"/>
					     	</c:url>
							<a href="${ticketUrl}">
								<c:out value="${kticket.pnr}"/>,&nbsp;<c:out value="${kticket.issue_date}"/>,&nbsp;<c:out value="${kticket.pax1Last_name}"/>
							</a><br/>
					    </c:forEach>
						
		            </TD>
	            	</TR>
	        	</TABLE>
	        	</TD>
	        </TR>
	        </TABLE>
			<br/>
			<html:submit value="CREATE NEW" onclick="javascript:setAction('add', this.form)"></html:submit>
	    </html:form>
	    </td></tr>
    </table>
</BODY></HTML>
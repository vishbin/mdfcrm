<!--
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*" %>
<%@ page import="mdf.forms.*" %>
<LINK HREF="mdfstyles.css" TYPE="text/css" REL="stylesheet" />
-->
<HTML>
<HEAD>
	<TITLE>Call Details</TITLE>
    <SCRIPT language="JavaScript">
    	var backup_form;
        function setAction(choice) {
			document.callFormBean.actionn.value='add';
   	        var f= document.callFormBean;
			f.actionn.value = choice;
			f.action = "call_action.do";
			f.action.value = "call_action.do";
			alert(f.action );
            f.submit();
        }
        function backup() {
   	        backup_form=document.forms[0].clone();
			alert(backup_form);        
        }
    </SCRIPT>
</HEAD>
<BODY BGCOLOR="#FDF5E6" onload="html:javascript:backup()">
<H1 class="blue">Contact Details</H1>
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
	<html:form action="call_action.do" >
		<html:submit value="NEW CALL" onclick="html:javascript:setAction('add')"></html:submit>
		<html:submit value="SAVE" onclick="html:javascript:setAction('save')"></html:submit>
		<html:submit value="DELETE" onclick="html:javascript:setAction('delete')"></html:submit>
	    <html:hidden property="actionn" value="add"/>
		<br/><br/>
		<B>AT A GLANCE CALL
		<TABLE width=800 border=2>
		<TR>
		<TD width=600>
			<TABLE border=1 width=100%>
			<TR>
			<TD>
			    <TABLE>

			    <TR>
			    <TD colspan =3><B>CALL INFO</TD>
			    </TR>
			    <TR><TD colspan=3>
			    Call ID <html:text property="call_id" size="4"></html:text>
			    </TD></TR>

			    <TR>
			    <TD><html:select property="channel">
					<html:option value="PHONE">Phone</html:option>
					<html:option value="EMAIL">Email</html:option>
				</html:select></TD>
				<td>Phone:<html:text property="number" size="10"></html:text></td>
				<td>Email:<html:text property="email" size="20"></html:text></td>
				</TR>
			    <TR>
			    <TD>CHANNEL</TD>
				<td><html:submit value="LOOKUP" onclick="html:javascript:setAction('lookupCall')"></html:submit></td>
				<td><html:submit value="LOOKUP" onclick="html:javascript:setAction('lookupEmail')"></html:submit></td>
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
				<td><html:submit value="lookupContact" onclick="html:javascript:setAction('lookupContact')"></html:submit></td>
				</TR>
				</TABLE>
				
				<TABLE>
				<TR>
				<TD><B>CONTACT LIST</TD>
				</TR>
				<c:forEach items="${callBean.contactLookupList}" var="kcontact">
				<TR>
				<TD><html:checkbox property="selectedItems" value="${kcontact.contact_id}" onchange="html:javascript:alert('kaushik1')">
				  	<c:url var="contactUrl" scope="page" value="/contacts_action.do">
			        	<c:param name="actionn" value="edit"/>
			         	<c:param name="contact_id" value="${kcontact.contact_id}"/>
			     	</c:url>
					<a href="${contactUrl}" target="_blank">
						<c:out value="${kcontact.ui_name}"/>
						<br><c:out value="${kcontact.ui_number}"/>
						<br><c:out value="${kcontact.ui_email}"/>
					</a><br/>
					</html:checkbox>
			    </TD></TR>
			    </c:forEach>
			    </TABLE>

				<TABLE>			    
			    <TR><TD><b>
			    CONTACT INFO
			    </TD></TR>
			    <TR><TD><input type="text" value="${callBean.contactForm.first_name}">
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
			    <B>CALL INFO
			    </TD></TR>
			    <TR><TD>
			    Call ID <html:text property="call_id"></html:text>
			    </TD></TR>
                </TABLE>
            </TD>
            </TR>
        </TABLE>
				
    </html:form>
</BODY></HTML>
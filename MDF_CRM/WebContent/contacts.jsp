<!--
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%@ page import="java.util.*" %>
<%@ page import="mdf.forms.*" %>

-->
<HTML>
<HEAD>
	<TITLE>Contact Add, search</TITLE>
    <SCRIPT language="JavaScript">
        function setAction(choice, form) {
   	        if (choice == 'add') {
   	        	form.action = "contacts_action.do";
   	        	form.actionn.value="add";
                form.submit();
   	        }

   	        if (choice == 'lookup') {
   	        	form.action = "contacts_lookup.do";
                form.submit();
   	        }

        }
    </SCRIPT>
</HEAD>
<BODY bgcolor="#9f9fff">
<H1>Contact updates</H1>
		<b><a href="agents_action.do?actionn=agent_dashboard&agent_name=NONE">Click here to view all UnAssigned requests</a></b>
		<br/><br/>
		<c:if test="${user.agent_name != ''}">
			<b><a href="agents_action.do?actionn=agent_dashboard&agent_name=${user.agent_name}">Click here to view ${user.agent_name} 's DashBoard</a></b>
		</c:if>
		<br/><br/>
	<html:form action="contacts_lookup.do" >
	    <html:hidden property="actionn" value="lookup"/>
        <html:submit value="LOOKUP" onclick="setAction('lookup', this.form)"></html:submit>
        <html:submit value="ADD" onclick="setAction('add', this.form)"></html:submit>
		<br/><br/>
		<table border=1>
		<tr border=0>
			<td>Name</td>
			<td><html:text property="ui_name"></html:text><br/></td>
		</tr>
		<tr>
        	<td>Number</td>
        	<td><html:text property="ui_number"></html:text><br/></td>
		</tr>
		<tr>
        	<td>Email</td>
        	<td><html:text property="ui_email"></html:text></td>
		</tr>
		</table>
		<br/>LISTING<br/>
		<c:forEach items="${contactList}" var="kcontact">
	      	<c:url var="contactUrl" scope="page" value="/contacts_action.do">
	        	<c:param name="actionn" value="edit"/>
	         	<c:param name="contact_id" value="${kcontact.contact_id}"/>
	     	</c:url>
			<a href="${contactUrl}" target="_blank">
				<c:out value="${kcontact.contact_name}"/>,&nbsp;<c:out value="${kcontact.contact_email}"/>,&nbsp;<c:out value="${kcontact.contact_phone}"/>
			</a><br/>
	    </c:forEach>
		

    </html:form>
</BODY></HTML>
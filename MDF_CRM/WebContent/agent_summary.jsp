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
	<TITLE>Agent Summary</TITLE>
    <SCRIPT language="JavaScript">
    	var backup_form;
        function setAction(choice, form) {
			form.actionn.value = choice;
			form.action = "agents_action.do";
            form.submit();
        }
    </SCRIPT>
</HEAD>
<BODY>
	<table>
	<tr><td>
	<html:form action="/agents_action.do" >
	    <html:hidden property="actionn" value="agent_summary" style="font-size:8px;"/>
		<B>AGENT SUMMARY &nbsp
		<html:submit value="REFRESH" onclick="javascript:setAction('agent_summary', this.form)"></html:submit>
		
		<TABLE width=100%>
		<TR>
		<TD>
			<table width=100%  border=1>
				<tr>
					<td>Agent Name</td>
					<td>Total Open</td>
					<td>Pending Itinerary</td>
					<td>Pending Followup</td>
					<td>Pending Docs</td>
					<td>Failed</td>
				</tr>				
				<c:forEach items="${agentList}" var="kagent">
					<c:url var="agentUrl" scope="page" value="/agents_action.do">
	        			<c:param name="actionn" value="agent_dashboard"/>
	         			<c:param name="agent_name" value="${kagent.agent_name}"/>
	     			</c:url>
				
				<tr>
					<td>
						<a href="${agentUrl}" target="_top">
							<c:out value="${kagent.agent_name}"/>
						</a><br/>
					</td>
					<td>
						<c:out value="${kagent.open_customers}"/>
	    			</td>
					<td>
						<c:out value="${kagent.pending_itinerary}"/>
	    			</td>
					<td>
						<c:out value="${kagent.pending_followup}"/>
	    			</td>
					<td>
						<c:out value="${kagent.pending_docs}"/>
	    			</td>
					<td>
						<c:out value="${kagent.failed_customers}"/>
	    			</td>
	    		</tr>
	    		</c:forEach>
		    </table>
        </TD>
        </TR>
        </TABLE>
				
    </html:form>
    </td></tr>
    </table>
</BODY></HTML>
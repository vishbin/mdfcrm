
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*"%>
<%@ page import="mdf.forms.*"%>


<HTML>
<HEAD>
<LINK HREF="css/mdfstyles.css" TYPE="text/css" REL="stylesheet" />
<TITLE>Agent Summary</TITLE>
	<SCRIPT language="JavaScript">
        function setAction(choice, form) {
			form.actionn.value = choice;
			form.action = "agents_action.do";
            form.submit();
        }
        function setContactsAction(choice, form) {
			form.actionn.value = choice;
			form.action = "contacts_action.do";
            form.submit();
        }
    </SCRIPT>
</HEAD>
<body bgcolor="#9f9fff">
<table border=1>


	<tr>

	<td>
		<b><a href="contacts_action.do?&actionn=ADD">Create New Contact</a></b>
	</td>
	<td>
		<b><a href="contacts.jsp">Search Contact</a></b>
	</td>

	<td>
		<c:if test="${user.agent_name == ''}">
			<c:set var="user.agent_name" scope="session" value="NONE" />
		</c:if>
		<c:if test="${agentFormBean.agent_name == ''}">
			<c:set var="agentFormBean.agent_name" scope="session" value="user.agent_name" />
		</c:if>
		<c:if test="${user.agent_name != agentFormBean.agent_name}">
			<b><a href="agents_action.do?actionn=agent_dashboard&agent_name=${user.agent_name}">Click here to view ${user.agent_name} 's DashBoard</a></b>
		</c:if>
	</td>

	<td>
		<c:if test="${agentFormBean.agent_name != 'NONE'}">
		<b><a href="agents_action.do?actionn=agent_dashboard&agent_name=NONE">Click here to view all UnAssigned requests</a></b>
		</c:if>
	</td>


	<td >
		<b><a href="ReportsMain.jsp">Click Here to Know What the Heck is going on in MDF</a></b>
	</td>

	</tr>

	<tr>
	<td colspan="5"  align="center">
		<b><c:out value="${agentFormBean.agent_name}"/>'s MDF DashBoard </b></td>
	</tr>
	<tr>
		<td colspan="5">
			<TABLE width=100%>
				<tr>
					<td><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
						codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0"
						height="20" width="1266">
						<param name="movie" value="flash/header.swf">
						<param name="quality" value="high">
						<embed src="flash/header.swf" quality="high"
							pluginspage="http://www.macromedia.com/go/getflashplayer"
							type="application/x-shockwave-flash" height="100" width="766"></object>
					</td>


				</tr>


			</TABLE>

		</td>
	</tr>
</table>
</BODY>
</HTML>

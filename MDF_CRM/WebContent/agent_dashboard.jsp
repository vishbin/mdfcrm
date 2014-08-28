
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*"%>
<%@ page import="mdf.forms.*"%>

<LINK HREF="css/mdfstyles.css" TYPE="text/css" REL="stylesheet" />
<HTML>
<HEAD>
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
	<tr><td>
	<iframe name="FRAME1" src='agents_action.do?actionn=agent_summary&agent_name=<c:out value="${user.agent_name}"/>' width=100% height=240px frameborder="1" scrolling="auto"></iframe>
	</td></tr>

	<tr>

	<td>
		<b><a href="contacts_action.do?&actionn=ADD">Create New Contact</a></b>
	</td>
	</tr>
	<tr>
	<td>
		<b><a href="contacts.jsp">Search Contact</a></b>
	</td>
	</tr>
	<tr>
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
	</tr>
	<tr>
	<td>
		<c:if test="${agentFormBean.agent_name != 'NONE'}">
		<b><a href="agents_action.do?actionn=agent_dashboard&agent_name=NONE">Click here to view all UnAssigned requests</a></b>
		</c:if>
	</td>
	</tr>

	<tr>
	<td style="text-align:center">
		<b><c:out value="${agentFormBean.agent_name}"/>'s MDF DashBoard </b></td>
	</tr>
	<tr>
		<td><html:form action="/agents_action.do">
			<TABLE width=100%>
				<tr>
					<td><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
						codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0"
						height="20" width="766">
						<param name="movie" value="flash/header.swf">
						<param name="quality" value="high">
						<embed src="flash/header.swf" quality="high"
							pluginspage="http://www.macromedia.com/go/getflashplayer"
							type="application/x-shockwave-flash" height="100" width="766"></object>
					</td>


				</tr>
				<TR>
					<TD>
					<table width=100% border=1>
						<tr>
							<td colspan=4 style="text-align:center"><b><c:out value="${agentFormBean.agent_name}"/> has following Open Customers</b></td>
						</tr>
						<tr>
							<td style="text-align:center"><b>Contact Name</b></td>
							<td style="text-align:center"><b>Status</b></td>
							<td style="text-align:center"><b>Last updated</b></td>
							<td style="text-align:center"><b>Stale</b></td>
						</tr>
						<c:forEach items="${contactList}" var="kcontact">
						<tr>
							<td>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.contact_name}" /> </a>
								<br />
							</td>

							<td>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.status}" /> </a>
								<br />


							</td>

							<td>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.update_dttm}" />,
									 <c:out
									value="${kcontact.updated_by}" /> </a>
								<br />


							</td>

							<td>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank">
									<c:out value="${kcontact.stale}" />
								</a>
								<br />


							</td>

						</tr>
						</c:forEach>
					</table>
					</TD>
				</TR>
			</TABLE>
		</html:form>
		</td>
	</tr>
</table>
</BODY>
</HTML>

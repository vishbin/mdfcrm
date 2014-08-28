
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*"%>
<%@ page import="mdf.forms.*"%>


<HTML>
<HEAD>
<LINK HREF="css/mdfstyles.css" TYPE="text/css" REL="stylesheet" />
<TITLE>My Dream Flight Reports</TITLE>

</HEAD>
<body bgcolor="#9f9fff">

					<table width=100% border=1>
<tr>
							<td align="center"><b>Contact Name</b></td>
							<td align="center"><b>Status</b></td>
							<td align="center"><b>Last updated</b></td>
							<td align="center"><b>Assigned Agent</b></td>
						</tr>
						<tr><td class="heading"  colspan="4">Open Customers Not Updated for More then 3 Days</td></tr>


						<c:forEach    items="${generateReportFormBean.custNotUpdatedLat3DaysList}" var="kcontact">
						<tr>
							<td align="left" border=1>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.contact_name}" /> </a>
								<br />
							</td>

							<td align="left" border=1>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.status}" /> </a>
								<br />


							</td>

							<td align="left" border=1>

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
							<td align="left" border=1>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.agent_assigned}" /> </a>
								<br />
							</td>

						</tr>
						</c:forEach>

						<tr><td class="heading" colspan="4">Customers Updates Today </td></tr>
						<c:forEach items="${generateReportFormBean.custUpdatedList}" var="kcontact">
						<tr>
							<td align="left" border=1>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.contact_name}" /> </a>
								<br />
							</td>

							<td align="left" border=1>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.status}" /> </a>
								<br />


							</td>

							<td align="left" border=1>

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
							<td align="left" border=1>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.agent_assigned}" /> </a>
								<br />
							</td>

						</tr>
						</c:forEach>


						<tr><td class="heading" colspan="4">Customers Added Today </td></tr>


						<c:forEach items="${generateReportFormBean.custAddedList}" var="kcontact">
						<tr>
							<td align="left" border=1>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.contact_name}" /> </a>
								<br />
							</td>

							<td align="left" border=1>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.status}" /> </a>
								<br />


							</td>

							<td align="left" border=1>

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
							<td align="left" border=1>

								<c:url var="contactUrl" scope="page" value="/contacts_action.do">
									<c:param name="actionn" value="edit" />
									<c:param name="contact_id" value="${kcontact.contact_id}" />
								</c:url>

								<a href="${contactUrl}" target="_blank"> <c:out
									value="${kcontact.agent_assigned}" /> </a>
								<br />
							</td>

						</tr>
						</c:forEach>







					</table>


</BODY>
</HTML>

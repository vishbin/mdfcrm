
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*"%>
<%@ page import="mdf.forms.*"%>

<LINK HREF="css/mdfstyles.css" TYPE="text/css" REL="stylesheet" />
<HTML>
<HEAD>
<TITLE>MDF STATS</TITLE>

</HEAD>
<body bgcolor="#9f9fff">
<table border=1>
<tr>
			<td colspan="4"><jsp:include page="MDF_Header.jsp"></jsp:include>
			</td>
		</tr>
				<TR>
					<TD>
					<table width=100% border=1>
						<tr>
							<td colspan=6 align="center"><b>Overall Summary from date ${generateReportFormBean.fromDate} TO ${generateReportFormBean.toDate}  </b></td>
						</tr>
						<tr>
							<td colspan=6 align="center"><b></b></td>
						</tr>
						<tr>

							<td align="center"><b>Total Num of Tickets</b></td>
							<td align="center"><b>Total Num of Tickets fromAMT</b></td>
							<td align="center"><b>Total Num of Tickets fromHYD</b></td>
							<td align="center"><b>Total Expenditure</b></td>
							<td align="center"><b>Total Num of  Itin Given</b></td>

						</tr>
						<tr>
							<td align="left" border=1>

								<a> <c:out value="${generateReportFormBean.totalNumofTickets}" /> </a>
								<br />
							</td>

							<td align="left" border=1>

								<a> <c:out value="${generateReportFormBean.totalNumOfTicketfromAMT}" /> </a>
								<br />
							</td>
							<td align="left" border=1>

								<a> <c:out value="${generateReportFormBean.totalNumOfTicketfromHYD}" /> </a>
								<br />
							</td>
							<td align="left" border=1>

								<a> <c:out value="${generateReportFormBean.totalExpenditure}" /> </a>
								<br />
							</td>
							<td align="left" border=1>

								<a> <c:out value="${generateReportFormBean.totalNumofItinGiven}" /> </a>
								<br />
							</td>



						</tr>


						<tr>
							<td colspan=6 align="center"><b></b></td>
						</tr>
						<tr>

							<td align="center"><b>Total Num of Cutomerscontacted</b></td>
							<td align="center"><b>Total Num of CutomersResponded</b></td>
							<td align="center"><b>Total Num of CutomersLost</b></td>
							<td align="center"><b>Top Reason for Losing Customer</b></td>
							<td align="center"><b>Top Agent by Tickets</b></td>





						</tr>
						<tr>
							<td align="left" border=1>

								<a> <c:out value="${generateReportFormBean.totalNumofCutomerscontacted}" /> </a>
								<br />
							</td>

							<td align="left" border=1>

								<a> <c:out value="${generateReportFormBean.totalNumofCutomersResponded}" /> </a>
								<br />
							</td>
							<td align="left" border=1>

								<a> <c:out value="${generateReportFormBean.totalNumofCutomersLost}" /> </a>
								<br />
							</td>
							<td align="left" border=1>

								<a> <c:out value="${generateReportFormBean.topReasonforLosingCustomer}" /> </a>
								<br />
							</td>
							<td align="left" border=1>

								<a> <c:out value="${generateReportFormBean.topAgentbyTickets}" /> </a>
								<br />
							</td>



						</tr>

						<tr>
							<td colspan=6 align="center"><b>  </b></td>
						</tr>

						<tr>
							<td colspan=6 align="center"><b>Agent Summary</b></td>
						</tr>
						<tr>
							<td align="center"><b>AgentName</b></td>
							<td align="center"><b>Number of Customer</b></td>
							<td align="center"><b>Number of Itinaries</b></td>
							<td align="center"><b>Number of Quotes</b></td>
							<td align="center"><b>Number of CustomerLost</b></td>
							<td align="center"><b>Number of Tickets</b></td>
						</tr>


						<c:forEach items="${generateReportFormBean.agentStatList}" var="myagent">
						<tr>
							<td align="left" border=1>

								<a> <c:out value="${myagent.agentName}" /> </a>
								<br />
							</td>

							<td align="left" border=1>

								<a> <c:out value="${myagent.numofCustomer}" /> </a>
								<br />
							</td>
							<td align="left" border=1>

								<a> <c:out value="${myagent.numofItinaries}" /> </a>
								<br />
							</td>
							<td align="left" border=1>

								<a> <c:out value="${myagent.numofQuotes}" /> </a>
								<br />
							</td>
							<td align="left" border=1>

								<a> <c:out value="${myagent.numofCustomerLost}" /> </a>
								<br />
							</td>
							<td align="left" border=1>

								<a> <c:out value="${myagent.numofTickets}" /> </a>
								<br />
							</td>


						</tr>
						</c:forEach>
					</table>
					</TD>
				</TR>
			</TABLE>

</BODY>
</HTML>

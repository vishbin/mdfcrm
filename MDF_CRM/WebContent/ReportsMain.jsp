
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*"%>
<%@ page import="mdf.forms.*"%>

<HTML>
<HEAD>

<link rel="stylesheet" href="css/mdfstyles.css" type="text/css">
<TITLE>MDF STATS</TITLE>


<script type="text/javascript">
function setToDtFieldNames(dd,mm,yyyy,cf)
{
	document.forms[0].toddfield.value = dd;
	document.forms[0].tommfield.value = mm;
	document.forms[0].toyyfield.value = yyyy;
	document.forms[0].tocfId.value = cf;
}
function setFromDtFieldNames(dd,mm,yyyy,cf)
{
	document.forms[0].ddfield.value = dd;
	document.forms[0].mmfield.value = mm;
	document.forms[0].yyfield.value = yyyy;
	document.forms[0].cfId.value = cf;
}
function subfrm(actions,form){

   	        	document.forms[0].actions.value=actions;
                document.forms[0].form.submit();
}


</script>

</HEAD>
<body bgcolor="#9f9fff">
<table border=1 cellpadding="4">

	<html:form action="/generateStat">
		<tr>
			<td colspan="4"><jsp:include page="MDF_Header.jsp"></jsp:include>
			</td>
		</tr>

		<tr>
			<td  class="warningtext" align="center"  colspan="4"><a >Works only Dates after 11/01/2007</a> </td>
		</tr>

		<tr>
			<td></td>
			<td>MM (Month)</td>
			<td>DD (Day)</td>
			<td>YYYY (Year)</td>
		</tr>



		<tr>
			<td>From Date</td>
			<td><html:text value="01" property="fromMM"></html:text></td>
			<td><html:text value="01" property="fromDD"></html:text></td>
			<td><html:text value="2007" property="fromYYYY"></html:text></td>
		</tr>



		<tr>
			<td>To Date</td>
			<td><html:text value="01" property="toMM"></html:text></td>
			<td><html:text value="01" property="toDD"></html:text></td>
			<td><html:text value="2007" property="toYYYY"></html:text></td>
		</tr>





		<tr>
			<td>From Date</td>
			<td colspan="3"><a href="#" border="0" id="atagclicked"
				onclick="calobj=this.parentNode.previousSibling;document.getElementById('fromcalendarframe').style.display='inline';clicked='true';setToDtFieldNames('generateReportFormBean.fromDD','generateReportFormBean.fromMM','generateReportFormBean.fromYYYY','fromcalendarframe');">
			<img src="img/cal.gif" alt="Calendar" border="0" height="16"
				width="16" /></a> <iframe align="center" src="calendar.html"
				id="fromcalendarframe" marginheight="0" marginwidth="0"
				scrolling="no"
				style="position: absolute; z-index: 100; display: none; width: 160px; height: 160px"
				frameborder="none"></iframe> <html:hidden
				name="generateReportFormBean" property="fromDate" /></td>
		</tr>

		<tr>
			<td>To Date</td>
			<td colspan="3"><a href="#" border="0" id="atagclicked"
				onclick="calobj=this.parentNode.previousSibling;document.getElementById('calendarframe').style.display='inline';clicked='true';setToDtFieldNames('generateReportFormBean.toDD','generateReportFormBean.toMM','generateReportFormBean.toYYYY','tocalendarframe');">
			<img src="img/cal.gif" alt="Calendar" border="0" height="16"
				width="16" /></a> <iframe align="center" src="calendar.html"
				id="tocalendarframe" marginheight="0" marginwidth="0" scrolling="no"
				style="position: absolute; z-index: 100; display: none; width: 160px; height: 160px"
				frameborder="none"></iframe> <html:hidden
				name="generateReportFormBean" property="toDate" /></td>
		</tr>





		<tr>

			<td colspan="4" align="center"><html:submit onclick="javascript:subfrm('range',this.form)"   styleClass="bigbutton"  value="Generate MDF STAT"></html:submit></td>

		</tr>

		<tr>

			<td colspan="4" align="center"><html:submit onclick="javascript:subfrm('today',this.form)" styleClass="bigbutton"  value="MDF STAT for Today "></html:submit></td>

		</tr>

		<tr>

			<td colspan="4" align="center"><html:submit onclick="javascript:subfrm('yest',this.form)" styleClass="bigbutton"  value="MDF STAT for Yesterday "></html:submit></td>

		</tr>
		<tr>

			<td colspan="4" align="center"><html:submit onclick="javascript:subfrm('3days',this.form)" styleClass="bigbutton"  value="Open Cust Not Updated for more than 3 days "></html:submit></td>

		</tr>


		<input type="hidden" id="toddfield" value="">
		<input type="hidden" id="tommfield" value="">
		<input type="hidden" id="toyyfield" value="">
		<input type="hidden" id="tocfId" value="">
		<input type="hidden" id="ddfield" value="">
		<input type="hidden" id="mmfield" value="">
		<input type="hidden" id="yyfield" value="">
		<input type="hidden" id="cfId" value="">
		<html:hidden property="actions" value=""/>



	</html:form>


</table>
</BODY>
</HTML>

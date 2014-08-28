


<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*"%>
<%@ page import="mdf.forms.*"%>
<title>MyDreamFlight Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<html>
<script language="javascript">

	function loginSubmit(form){
	alert('1');
		form.action = "login_action.do";
    	form.submit();
	}
</script>
<body bgcolor="#9f9fff" onLoad="document.agentFormBean.agent_name.focus()">

<html:form action="login_action.do">
<table width="500" border="0" cellspacing="0" cellpadding="0">
	<tr>

		<td><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
			codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0"
			height="194" width="766">
			<param name="movie" value="flash/header.swf">
			<param name="quality" value="high">
			<embed src="flash/header.swf" quality="high"
				pluginspage="http://www.macromedia.com/go/getflashplayer"
				type="application/x-shockwave-flash" height="194" width="766"></object>
		</td>



	</tr>

	<tr>
		<td>
		<table width="500" border="0" cellspacing="0" cellpadding="0">

				<tr>
				</tr>


				<tr>
					<td height="50" width="100"><IMG src="img/spacer.gif"></td>
					<td width="401">
					<div align="right"><b>Agent Name</b> &nbsp;&nbsp;  </div>
					</td>
					<td width="399"><html:text property="agent_name"></html:text></td>
					<td height="50" width="100"><IMG src="img/spacer.gif"></td>
				</tr>

				<tr>
					<td height="50" width="100"><IMG src="img/spacer.gif"></td>
					<td width="401">
					<div align="right"><b>Password:(Blank for Now)</b>&nbsp;&nbsp;   </div>
					</td>
					<td width="399"><html:text property="agent_name"></html:text></td>
					<td height="50" width="100"><IMG src="img/spacer.gif"></td>
				</tr>

				<tr>
					<td height="50" width="100"><IMG src="img/spacer.gif"></td>
					<td width="401"></td>
					<td width="399"><br>

			<html:submit value="LOGIN" onclick="javascript:setAction('login', this.form)"></html:submit>


				</tr>
<tr>

	<td colspan="4">
		<b><a href="ReportsMain.jsp">Click Here to Know What the Heck is going on in MDF (BETA)</a></b>
	</td>
	</tr>

		</table>
		</td>
	</tr>
</table>
</html:form>
</body>
</html>

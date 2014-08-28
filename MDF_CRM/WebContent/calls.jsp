<!--
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%@ page import="java.util.*" %>
<%@ page import="mdf.forms.*" %>

-->
<LINK HREF="mdfstyles.css" TYPE="text/css" REL="stylesheet" />
<HTML>
<HEAD>
	<TITLE>Call Enter, search</TITLE>
    <SCRIPT language="JavaScript">
        function setAction(choice, form) {
   	        if (choice == 'add') {
   	        alert('kaushik');
   	        	form.action = "call_action.do";
   	        	form.actionn.value="add";
                form.submit();
   	        }

   	        if (choice == 'lookup') {
   	        	form.action = "call_lookup.do";
                form.submit();
   	        }

   	        if (choice == 'reset') {
    	        form.action = "/tst/do/ExecutionsReset";
                form.submit();
   	        }

        }
    </SCRIPT>
</HEAD>
<BODY>
<H1>Call updates</H1>
	<html:form action="call_action.do" >
	    <html:hidden property="actionn" value="add"/>
        <html:submit value="LOOKUP" onclick="setAction('lookup', this.form)"></html:submit>
        <html:submit value="ADD" onclick="setAction('add', this.form)"></html:submit>
		<br/><br/>

    </html:form>
</BODY></HTML>
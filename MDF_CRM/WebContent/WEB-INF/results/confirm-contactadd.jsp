<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>Success</TITLE></HEAD>
<BODY BGCOLOR="#FDF5E6">
<CENTER>
<H1>You have added successfully.</H1>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<UL>
  <LI>First Name: 
      <bean:write name="contactFormBean" property="first_name"/>
  <LI>Last Name: 
      <bean:write name="contactFormBean" property="last_name"/>
</UL>
Congratulations.
</CENTER>
</BODY></HTML>
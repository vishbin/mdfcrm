<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>Success</TITLE></HEAD>
<BODY BGCOLOR="#FDF5E6">
<CENTER>
<H1>You have registered successfully.</H1>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<UL>
  <LI>Email Address: 
      <bean:write name="userFormBean" property="email"/>
  <LI>Password: 
      <bean:write name="userFormBean" property="password"/>
</UL>
Congratulations.
</CENTER>
</BODY></HTML>
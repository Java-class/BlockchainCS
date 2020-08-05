<%@ page import="util.Util" %>
<%@ page import="util.Log" %>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>

<%
    String exp = (exception != null ? exception.toString() : null);
    String status_code = Util.tryToString(String.valueOf(request.getAttribute("javax.servlet.error.status_code")), "");
    String message = Util.tryToString(String.valueOf(request.getAttribute("javax.servlet.error.message")), "");
    String request_uri = Util.tryToString(String.valueOf(request.getAttribute("javax.servlet.error.request_uri")), "");
    Log.infoLog(message);
    Log.infoLog(exp);

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Error</title>
    <base href="${pageContext.request.contextPath}"/>
</head>

<body>
<div class="cur-error">Error <%=status_code%></div>

<% if (exp != null) { %>
<div class="Error">خطای رخ داده است.</div>
<% } %>

<table width="100%">
    <tr>
        <td class="label">Message</td>
        <td class="value">خطایی رخ داده است.</td>
    </tr>
    <tr>
        <td class="label">Uri</td>
        <td class="value"><%=request_uri%></td>
    </tr>
</table>
</body>
</html>
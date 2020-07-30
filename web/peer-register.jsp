<%--
  Created by IntelliJ IDEA.
  User: Mostafa
  Date: 7/30/2020
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Peer | Register</title>

</head>
<body>
<form action="${pageContext.request.contextPath}/peercontroller.srv" method="post">
    <label>Public Key <input type = "text" name = "public_key"></label>
    <br />
    <label>PrivateKey <input type = "password" name = "private_key" /></label>
    <br>
    <label>Total Space <input type="number" name="total_space"> GB</label>
    <br>
    <input type = "submit" value = "Submit"/>
</form>
</body>
</html>

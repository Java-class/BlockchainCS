<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Peer | Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login.srv" method="post">
    <label>Public Key <input type = "text" name = "public_key"></label>
    <br>
    <label>PrivateKey <input type = "password" name = "private_key"/></label>
    <br>
    <input type = "submit" value = "Submit"/>
</form>

</body>
</html>

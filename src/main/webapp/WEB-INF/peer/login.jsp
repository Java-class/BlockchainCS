<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Peer | Login</title>
</head>
<body>
<form action="/loginPeer" method="post">
    <label>Public Key <input type = "text" name = "publicKey"></label>
    <br>
    <label>PrivateKey <input type = "password" name = "privateKey"/></label>
    <br>
    <input type = "submit" value = "Submit"/>
</form>

</body>
</html>

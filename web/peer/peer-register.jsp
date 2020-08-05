<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Peer | Register</title>

</head>
<body>
<form action="${pageContext.request.contextPath}/peer/registercontroller.srv" method="post">
    <label>Public Key <input type = "text" name = "public_key"></label>
    <br />
    <label>PrivateKey <input type = "password" name = "private_key"/></label>
    <br>
    <label>Total Space <input type="number" name="total_space"> GB</label>
    <br>
    <label>Max Supported User <input type="number" name="usr-count"></label>
    <br>
    <label>Max Bandwidth <input type="number" name="bandwidth"> MB/s</label>
    <br>
    <label>Uptime Percentage <input type="number" name="up-time"> % </label>
    <br>
    <label>Public Url <input type="url" name="url"></label>
    <br>
    <label>Available Time Range</label>
    <select id="av-range" name="av-range">
        <option value="7*24">7*24</option>
        <option value="7*18">7*18</option>
        <option value="5*24">5*24</option>
        <option value="5*18">5*18</option>
    </select>
    <br>
    <input type = "submit" value = "Submit"/>
</form>
</body>
</html>

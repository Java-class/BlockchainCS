<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Peer | Register</title>

</head>
<body>
<form action="/registerPeer" method="post">
    <label>Public Key <input type = "text" name = "publicKey"></label>
    <br>
    <label>PrivateKey <input type = "password" name = "privateKey"/></label>
    <br>
    <label>Total Space <input type="number" name="totalSpace"> GB</label>
    <br>
    <label>Max Supported User <input type="number" name="maxUserCount"></label>
    <br>
    <label>Max Bandwidth <input type="number" name="maxBandwidth"> MB/s</label>
    <br>
    <label>Uptime Percentage <input type="number" name="upTimePercentage"> % </label>
    <br>
    <label>Public Url <input type="url" name="url"></label>
    <br>
    <label>Available Time Range</label>
    <select id="availableRange" name="availableRange">
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

<%@ page import="ir.javaclass.entity.Peer" %>
<%@ page import="ir.javaclass.dao.PeerSettingRepository" %>
<%@ page import="ir.javaclass.entity.PeerSetting" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Peer info = (Peer) session.getAttribute("peer-info");
    System.out.println("@@@@@ "  + info.toString());
    PeerSetting setting = PeerSettingRepository.getSetting(info.getOwner());
%>
<html>
<head>
    <title>Peer | Dashboard</title>
</head>
<body>

<%-- form for local setting --%>
<form method="post" action="${pageContext.request.contextPath}/peer/local-setting.srv">
    <input type="hidden" name="public_key" value="<%=info.getOwner()%>">
    <label> MountAddress <input type="text" name="address" value="<%=(setting!=null)?setting.getMountAddress():""%>"></label>
    <input type="submit" value="Submit">
</form>

<%-- form for peer setting --%>
<form method="post" action="${pageContext.request.contextPath}/peer/peer-setting.srv">
    <label>Total Space <input type="number" name="total_space" value="<%=info.getTotalSpace()%>"> GB</label>
    <br>
    <label>Max Supported User <input type="number" name="usr-count" value="<%=info.getMaxUser()%>"></label>
    <br>
    <label>Max Bandwidth <input type="number" name="bandwidth" value="<%=info.getMaxBandwidth()%>"> MB/s</label>
    <br>
    <label>Uptime Percentage <input type="number" name="up-time" value="<%=info.getUptimePercentage()%>"> % </label>
    <br>
    <label>Public Url <input type="url" name="url" value="<%=info.getUrl()%>"></label>
    <br>
    <label>Available Time Range</label>
    <select id="av-range" name="av-range">
        <option selected="selected" value="<%=info.getAvailableTimeRange()%>"><%=info.getAvailableTimeRange()%></option>
        <option value="7*24">7*24</option>
        <option value="7*18">7*18</option>
        <option value="5*24">5*24</option>
        <option value="5*18">5*18</option>
    </select>
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>

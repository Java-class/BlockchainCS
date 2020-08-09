package ir.javaclass.controller;

import ir.javaclass.entity.Peer;
import ir.javaclass.service.PeerService;
import ir.javaclass.util.Log;
import ir.javaclass.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PeerSettingController",value = "/peer/peer-setting.srv")
public class PeerSettingController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Peer peer = (Peer) session.getAttribute("peer-info");
        String private_key = (String) session.getAttribute("peer-pk");
        String av_range = Util.tryToString(request.getParameter("av-range"), "7*24");
        long totalSpace = Util.tryToLong(request.getParameter("total_space"), -1);
        int maxUserCount = Util.tryToInt(request.getParameter("usr-count"), 0);
        long maxBandwidth = Util.tryToLong(request.getParameter("bandwidth"), -1);
        int upTimePercentage = Util.tryToInt(request.getParameter("up-time"), 0);
        String url = Util.tryToString(request.getParameter("url"), "");
        try {
            if(!av_range.equals(peer.getAvailableTimeRange()))
                PeerService.updateAvailableTimeRange(private_key,peer.getId(),av_range);
            else if(totalSpace!=peer.getTotalSpace())
                PeerService.updateTotalSpace(private_key,peer.getId(),totalSpace);
            else if(maxUserCount!=peer.getMaxUser())
                PeerService.updateMaxUser(private_key,peer.getId(),maxUserCount);
            else if(maxBandwidth!=peer.getMaxBandwidth())
                PeerService.updateMaxBandwidth(private_key,peer.getId(),maxBandwidth);
            else if(upTimePercentage!=peer.getUptimePercentage())
                PeerService.updateUptimePercentage(private_key,peer.getId(),upTimePercentage);
            else if(!url.equals(peer.getUrl()))
                PeerService.updatePublicUrl(private_key,peer.getId(),url);
            peer = PeerService.getPeer(peer.getOwner(),private_key);
            session.setAttribute("peer-info",peer);
            response.sendRedirect("/peer/dashboard.jsp");
        } catch (Exception ex) {
            Log.errorLog(ex);
            response.sendRedirect("/error.jsp");
        }
    }
}

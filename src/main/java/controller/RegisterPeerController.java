package controller;

import entity.Peer;
import service.PeerService;
import util.Log;
import util.Util;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterPeerController",value = "/peer/registercontroller.srv")
public class RegisterPeerController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        String public_key = Util.tryToString(request.getParameter("public_key"), "");
        String private_key = Util.tryToString(request.getParameter("private_key"), "");
        String av_range = Util.tryToString(request.getParameter("av-range"), "7*24");
        long totalSpace = Util.tryToLong(request.getParameter("total_space"), -1);
        int maxUserCount = Util.tryToInt(request.getParameter("usr-count"), 0);
        long maxBandwidth = Util.tryToLong(request.getParameter("bandwidth"), -1);
        int upTimePercentage = Util.tryToInt(request.getParameter("up-time"), 0);
        String url = Util.tryToString(request.getParameter("url"), "");

        Peer newPeer = new Peer(url, totalSpace, maxBandwidth, maxUserCount, upTimePercentage, av_range);
        System.out.println(newPeer.toString());
        try {
            PeerService.registerPeer(private_key, newPeer);
            session.setAttribute("peer-info",newPeer);
            response.sendRedirect("/peer/dashboard");
        } catch (Exception e) {
            Log.errorLog(e);
            response.sendRedirect("/error.jsp");
        }
    }
}

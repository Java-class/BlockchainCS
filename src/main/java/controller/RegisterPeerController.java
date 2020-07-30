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

@WebServlet(name = "RegisterPeerController",value = "/peercontroller.srv")
public class RegisterPeerController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        String public_key = Util.tryToString(request.getParameter("public_key"), "");
        String private_key = Util.tryToString(request.getParameter("private_key"), "");
        long totalSpace = Util.tryToLong(request.getParameter("total_space"),-1);
        String url = Util.tryToString(request.getParameter("url"),"");
        try {
            Peer newPeer = new Peer(url, totalSpace, 0, 0, 0, null);
            System.out.println(newPeer.toString());
            //PeerService.registerPeer(private_key,newPeer);
        }catch (Exception ex){
            Log.errorLog(ex);
        }
    }
}

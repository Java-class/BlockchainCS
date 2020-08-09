package ir.javaclass.controller;

import ir.javaclass.entity.Peer;
import ir.javaclass.service.PeerService;
import ir.javaclass.util.Log;
import ir.javaclass.util.Util;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController",value = "/login.srv")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        String public_key = Util.tryToString(request.getParameter("public_key"), "");
        String private_key = Util.tryToString(request.getParameter("private_key"), "");
        try {
            Peer peer = PeerService.getPeer(public_key, private_key);
            System.out.println("#### " + peer.toString());
            if(peer!=null) {
                session.setAttribute("peer-info", peer);
                session.setAttribute("peer-pk",private_key);
                response.sendRedirect("/peer/dashboard.jsp");
            }//// not found page...
        } catch (Exception e) {
            Log.errorLog(e);
            response.sendRedirect("/error.jsp");
        }
    }

}

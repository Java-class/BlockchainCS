package ir.javaclass.controller;

import ir.javaclass.dao.PeerSettingRepository;
import ir.javaclass.entity.PeerSetting;
import ir.javaclass.service.SettingService;
import ir.javaclass.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LocalSettingController",value = "/peer/local-setting.srv")
public class LocalSetting extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String public_key = Util.tryToString(request.getParameter("public_key"), "");
        String mount_address = Util.tryToString(request.getParameter("address"), "");
//        PeerSetting peerSetting = PeerSettingRepository.getSetting(public_key);
//        if(peerSetting!=null){
//            peerSetting.setMountAddress(mount_address);
//            SettingService.savePeerSetting(peerSetting);
//            response.sendRedirect("/peer/dashboard.jsp");
//
//        }else {
//            peerSetting = new PeerSetting(public_key, mount_address);
//            SettingService.savePeerSetting(peerSetting);
//            response.sendRedirect("/peer/dashboard.jsp");
//        }
    }
}

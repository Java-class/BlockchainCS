package ir.javaclass.controller;

import ir.javaclass.entity.Peer;
import ir.javaclass.entity.PeerSetting;
import ir.javaclass.model.PeerInfoModel;
import ir.javaclass.model.PeerLoginModel;
import ir.javaclass.service.PeerService;
import ir.javaclass.service.SettingService;
import ir.javaclass.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("session")
@SessionAttributes("peer-info")
public class LoginController {

    @Autowired
    SettingService settingService;

    @RequestMapping(value = "/loginPeer", method = RequestMethod.POST)
    public String loginPeer(Model model, @ModelAttribute("SpringWeb") PeerLoginModel peerModel){
        System.out.println("login peer is called");
        System.out.println(peerModel.toString());
        try {
            Peer peer = PeerService.getPeer(peerModel.getPublicKey(), peerModel.getPrivateKey());
            PeerSetting setting = settingService.loadPeerSetting(peer.getOwner());
            PeerInfoModel peerInfo = new PeerInfoModel(peer, setting);
            peerInfo.setPrivateKey(peerModel.getPrivateKey());
            System.out.println("#### " + peer.toString());
            if(peer!=null) {
                model.addAttribute("peer-info",peerInfo);
                //return "dashboard";
                return "redirect:dashboard";
//                session.setAttribute("peer-info", peer);
//                session.setAttribute("peer-pk",private_key);
//                response.sendRedirect("/peer/dashboard.jsp");
            }else{
                /// return mesage to user1
            }
        } catch (Exception e) {
            Log.errorLog(e);
            //response.sendRedirect("/error.jsp");
        }
        return "login";
    }

}

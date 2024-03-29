//package ir.javaclass.controller;
//
//import ir.javaclass.entity.PeerSetting;
//import ir.javaclass.model.PeerInfoModel;
//import ir.javaclass.model.PeerLoginModel;
//import ir.javaclass.service.SettingService;
//import ir.javaclass.util.Log;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//
//@Controller
//@Scope("session")
//public class LocalSettingController {
//
//    @Autowired
//    private SettingService settingService;
//
//
//    @RequestMapping(value = "/localSetting", method = RequestMethod.POST)
//    public String localSetting(HttpServletRequest request, Model model, @ModelAttribute("SpringWeb") PeerLoginModel peerModel){
//        System.out.println("dashoard peer is called");
//        String publicKey = request.getParameter("public_key");
//        String mountAddress = request.getParameter("address");
//        try {
//            PeerSetting peerSetting = settingService.loadPeerSetting(publicKey);
//            if(peerSetting!=null){
//                peerSetting.setMountAddress(mountAddress);
//            }else{
//                peerSetting = new PeerSetting(publicKey, mountAddress);
//            }
//            settingService.savePeerSetting(peerSetting);
//            HttpSession session = request.getSession(true);
//            PeerInfoModel infoModel = (PeerInfoModel) session.getAttribute("peer-info");
//            infoModel.setSetting(peerSetting);
//            model.addAttribute("peer-info",infoModel);
//            return "redirect:dashboard";
//        } catch (Exception e) {
//            Log.errorLog(e);
//        }
//        return "login";
//    }
//}

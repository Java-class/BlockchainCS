//package ir.javaclass.controller;
//
//import ir.javaclass.entity.Peer;
//import ir.javaclass.model.PeerInfoModel;
//import ir.javaclass.service.PeerService;
//import ir.javaclass.util.Log;
//import ir.javaclass.util.Util;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@Controller
//@Scope("session")
//public class PeerSettingController {
//
//
//    @RequestMapping(value = "/peerSetting", method = RequestMethod.POST)
//    public String localSetting(HttpServletRequest request){
//        HttpSession session = request.getSession(true);
//        PeerInfoModel infoModel = (PeerInfoModel) session.getAttribute("peer-info");
//        Peer peer =null;
//        if(infoModel!=null)
//            peer = infoModel.getPeer();
//        String private_key = infoModel.getPrivateKey();
//        String av_range = Util.tryToString(request.getParameter("av-range"), "7*24");
//        long totalSpace = Util.tryToLong(request.getParameter("total_space"), -1);
//        int maxUserCount = Util.tryToInt(request.getParameter("usr-count"), 0);
//        long maxBandwidth = Util.tryToLong(request.getParameter("bandwidth"), -1);
//        int upTimePercentage = Util.tryToInt(request.getParameter("up-time"), 0);
//        String url = Util.tryToString(request.getParameter("url"), "");
//        try {
//            if(!av_range.equals(peer.getAvailableTimeRange()))
//                PeerService.updateAvailableTimeRange(private_key,peer.getId(),av_range);
//            else if(totalSpace!=peer.getTotalSpace())
//                PeerService.updateTotalSpace(private_key,peer.getId(),totalSpace);
//            else if(maxUserCount!=peer.getMaxUser())
//                PeerService.updateMaxUser(private_key,peer.getId(),maxUserCount);
//            else if(maxBandwidth!=peer.getMaxBandwidth())
//                PeerService.updateMaxBandwidth(private_key,peer.getId(),maxBandwidth);
//            else if(upTimePercentage!=peer.getUptimePercentage())
//                PeerService.updateUptimePercentage(private_key,peer.getId(),upTimePercentage);
//            else if(!url.equals(peer.getUrl()))
//                PeerService.updatePublicUrl(private_key,peer.getId(),url);
//
//            peer = PeerService.getPeer(peer.getOwner(),private_key);
//            infoModel.setPeer(peer);
//            session.setAttribute("peer-info",infoModel);
//            return "redirect:dashboard";
//        } catch (Exception ex) {
//            Log.errorLog(ex);
//        }
//        return "redirect:login";
//    }
//}

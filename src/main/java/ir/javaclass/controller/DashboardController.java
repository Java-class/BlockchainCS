/*
package ir.javaclass.controller;


import ir.javaclass.util.Log;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@Scope("session")
@SessionAttributes("peer-info")
public class DashboardController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String loadDashboard(Model model){
        System.out.println("dashoard peer is called");
        try {
            if(model.containsAttribute("peer-info"))
                return "dashboard";
        } catch (Exception e) {
            Log.errorLog(e);
            //response.sendRedirect("/error.jsp");
        }
        return "login";
    }
}
*/

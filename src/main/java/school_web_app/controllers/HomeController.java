package school_web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"/home","/",""})
    public  String home(Model model){
        model.addAttribute("username","Youssef Zahi");
        return  "home.html";
    }
}

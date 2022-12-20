package school_web_app.controllers;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String displayContactPage(){
        return "contact.html";
    }

    @PostMapping(value = "/saveMsg")
    public ModelAndView saveMessage(@RequestParam String name,@RequestParam String mobileNum,
            @RequestParam String email,@RequestParam String subject,@RequestParam String message){
        System.out.println("Name :"+name);
        return new ModelAndView("redirect:/contact");
    }

}

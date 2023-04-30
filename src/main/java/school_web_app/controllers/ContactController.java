package school_web_app.controllers;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import school_web_app.model.Contact;
import school_web_app.service.ContactService;

import java.util.List;

@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage(Model model){
        model.addAttribute("contact",new Contact());
        return "contact.html";
    }

    @PostMapping(value = "/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.error("Error in contact form validation : "+errors.toString());
            return "contact.html";
        }
        log.info(String.valueOf(contact));
        contactService.submitContactFormDetail(contact);
        return "redirect:/contact";
    }
    @GetMapping(value = "/displayMessages")
    public ModelAndView displayMessages(Model model){
        List<Contact> contactMsgs= contactService.findMsgsWithOpenStatus();

        for (Contact item : contactMsgs) {
            System.out.println("this is the contact from the CONTROLLER : "+item.toString());
        }
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs",contactMsgs);
        return modelAndView;
    }

    @GetMapping(value = "/closeMsg")
    public String closeMsg(@RequestParam  int id){
        contactService.updateMsgStatus(id);
        return "redirect:/displayMessages";
    }

}

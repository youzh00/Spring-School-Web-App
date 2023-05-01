package school_web_app.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import school_web_app.model.Person;
import school_web_app.repository.PersonRepository;
import school_web_app.service.PersonService;

@Slf4j
@Controller
@RequestMapping("public")
public class RegisterController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;
    @GetMapping("/register")
    public String displayRegisterPage(Model model) {
        model.addAttribute("person", new Person());
        return "register.html";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors) {
        if(errors.hasErrors()){
            return "register.html";
        }
        boolean isSaved=personService.createUser(person);
        if(isSaved){
            return "redirect:/login?register=true";

        }else {
            return "redirect:/public/register";
        }

    }
}

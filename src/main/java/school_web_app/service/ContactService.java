package school_web_app.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school_web_app.model.Contact;

@Slf4j
@Service
public class ContactService {

    public boolean submitContactFormDetail(Contact contact){
        boolean isSaved=true;

        //TODO- persist data to the DB
        System.out.println(contact.toString());
        return isSaved;
    }

}


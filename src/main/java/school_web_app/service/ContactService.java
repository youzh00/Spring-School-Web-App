package school_web_app.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_web_app.constants.SchoolConstants;
import school_web_app.model.Contact;
import school_web_app.repository.ContactRepository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService {

    @Autowired
    private  ContactRepository contactRepository;


    public boolean submitContactFormDetail(Contact contact){
        boolean isSaved=false;

        contact.setStatus(SchoolConstants.OPEN);
        contact.setCreatedBy(SchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());

        int result=contactRepository.saveContactMsg(contact);

        if (result>0) isSaved=true;
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsg=contactRepository.findMsgsWithStatus(SchoolConstants.OPEN);
        for (Contact item : contactMsg) {
            System.out.println("this is the contact : "+item.toString());
        }
        return contactMsg;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated=false;
        int result = contactRepository.updateMsgStatus(contactId,SchoolConstants.CLOSE, updatedBy);

        if (result>0) isUpdated=true;

        return isUpdated;
    }
}


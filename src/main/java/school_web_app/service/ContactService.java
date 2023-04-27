package school_web_app.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_web_app.constants.SchoolConstants;
import school_web_app.model.Contact;
import school_web_app.repository.ContactRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {

    @Autowired
    private  ContactRepository contactRepository;


    public boolean submitContactFormDetail(Contact contact){
        boolean isSaved=false;

        contact.setStatus(SchoolConstants.OPEN);

        Contact savedContact=contactRepository.save(contact);

        if (savedContact!=null && savedContact.getContactId()>0) isSaved=true;
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsg=contactRepository.findContactsByStatus(SchoolConstants.OPEN);
        for (Contact item : contactMsg) {
            System.out.println("this is the contact : "+item.toString());
        }
        return contactMsg;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated=false;
        Optional<Contact> optionalContact=contactRepository.findById(contactId);
        optionalContact.ifPresent(contact -> {
            contact.setStatus(SchoolConstants.CLOSE);
        });

        Contact updatedContact=contactRepository.save(optionalContact.get());
        if (updatedContact != null && updatedContact.getContactId()>0) isUpdated=true;

        return isUpdated;
    }
}


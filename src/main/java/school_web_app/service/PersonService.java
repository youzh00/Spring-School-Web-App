package school_web_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_web_app.constants.SchoolConstants;
import school_web_app.model.Person;
import school_web_app.model.Roles;
import school_web_app.repository.PersonRepository;
import school_web_app.repository.RolesRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createUser(Person person){
        boolean isSaved=false;
        Roles role=rolesRepository.getByRoleName(SchoolConstants.STUDENT_ROLE);
        person.setRole(role);
        person=personRepository.save(person);
        if (person!=null && person.getPersonId()>0){
            isSaved=true;
        }
        return isSaved;
    }
}

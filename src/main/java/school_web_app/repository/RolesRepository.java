package school_web_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import school_web_app.model.Roles;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
}

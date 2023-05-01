package school_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_web_app.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

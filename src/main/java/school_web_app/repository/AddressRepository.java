package school_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school_web_app.model.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}

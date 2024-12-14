package pzn.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pzn.restful.entity.Address;
import pzn.restful.entity.Contact;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, String> {

    Optional<Address> findFirstByContactAndId(Contact contact, String id);
}

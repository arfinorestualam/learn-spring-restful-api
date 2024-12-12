package pzn.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pzn.restful.entity.Contact;
import pzn.restful.entity.User;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, String> , JpaSpecificationExecutor<Contact> {

    Optional<Contact> findFirstByUserAndId(User user, String id);

    //cause the search contact api can be multiple conditions, we add jpa spec

}

package pzn.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pzn.restful.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, String> {
}

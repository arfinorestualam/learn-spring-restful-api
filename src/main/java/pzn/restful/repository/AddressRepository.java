package pzn.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pzn.restful.entity.Address;

public interface AddressRepository extends JpaRepository<Address, String> {
}

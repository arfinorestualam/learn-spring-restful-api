package pzn.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pzn.restful.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    //query method to check if user has token or not
    Optional<User> findFirstByToken(String token);
}

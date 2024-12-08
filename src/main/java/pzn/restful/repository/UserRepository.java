package pzn.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pzn.restful.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}

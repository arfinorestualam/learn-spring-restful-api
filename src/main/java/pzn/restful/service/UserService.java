package pzn.restful.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pzn.restful.entity.User;
import pzn.restful.model.RegisterUserRequest;
import pzn.restful.repository.UserRepository;
import pzn.restful.security.BCrypt;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Transactional
    public void registerUser(RegisterUserRequest registerUserRequest) {
        Set<ConstraintViolation<RegisterUserRequest>> constraintViolations = validator.validate(registerUserRequest);
        //check is data empty or not
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }

        //check if data already exist or not
        if (userRepository.existsById(registerUserRequest.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }

        //set before save
        User user = new User();
        user.setUsername(registerUserRequest.getUsername());
        //search spring security github BCrypt, to github, select raw, copy all paste to package security
        user.setPassword(BCrypt.hashpw(registerUserRequest.getPassword(), BCrypt.gensalt()));
        user.setName(registerUserRequest.getName());

        userRepository.save(user);
    }
}

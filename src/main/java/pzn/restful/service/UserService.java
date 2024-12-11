package pzn.restful.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pzn.restful.entity.User;
import pzn.restful.model.RegisterUserRequest;
import pzn.restful.model.UpdateUserRequest;
import pzn.restful.model.UserResponse;
import pzn.restful.repository.UserRepository;
import pzn.restful.security.BCrypt;

import java.util.Objects;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void registerUser(RegisterUserRequest registerUserRequest) {
        //check is data empty or not
        validationService.validate(registerUserRequest);
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

    }

    //cause there is no username, so we can get username from the Token
    //cause the token logic is use in everywhere, there is two ways Interceptor or Argument Resolver
    //but the tutor decide use Argument Resolver
    public UserResponse get(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }

    @Transactional
    public UserResponse update(User user, UpdateUserRequest request) {
        //to validate, request is not empty all
        validationService.validate(request);

        //check if name is not null
        if (Objects.nonNull(request.getName())) {
            //update name
           user.setName(request.getName());
        }

        //check if password not null
        if (Objects.nonNull(request.getPassword())) {
            //update password
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }

        //save to db
        userRepository.save(user);

        return UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }

}
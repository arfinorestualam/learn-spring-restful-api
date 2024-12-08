package pzn.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pzn.restful.model.RegisterUserRequest;
import pzn.restful.model.WebResponse;
import pzn.restful.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        userService.registerUser(registerUserRequest);
        return WebResponse.<String>builder().data("OK").build();
    }
}

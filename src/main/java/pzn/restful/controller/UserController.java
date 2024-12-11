package pzn.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pzn.restful.entity.User;
import pzn.restful.model.RegisterUserRequest;
import pzn.restful.model.UpdateUserRequest;
import pzn.restful.model.UserResponse;
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


    @GetMapping(
            path = "/api/users/current",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    //to check if data has token or not, we use User entity, and the logic is in UserArgumentResolver class
    //and any logic that need token check can use this controller,cause it has been add in UserArgumentResolver
    public WebResponse<UserResponse> get(User user) {
        UserResponse userResponse = userService.get(user);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }

    @PatchMapping(
            path = "/api/users/current",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> update(User user, @RequestBody UpdateUserRequest request) {
        UserResponse response = userService.update(user, request);
        return WebResponse.<UserResponse>builder().data(response).build();
    }
}

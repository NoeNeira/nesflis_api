package neflis.neflisdemo.controller;

import neflis.neflisdemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/users")




}

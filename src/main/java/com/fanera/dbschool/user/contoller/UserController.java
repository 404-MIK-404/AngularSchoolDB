package com.fanera.dbschool.user.contoller;


import com.fanera.dbschool.app.entity.USER_SCHOOL;
import com.fanera.dbschool.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/dbschool/user",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/signin")
    public String signInUser(@RequestBody USER_SCHOOL user){
        return userService.signInUser(user);
    }

    @PostMapping(value = "/signup")
    public String signUpUser(@RequestBody USER_SCHOOL user){
        return userService.signUpUser(user);
    }


}

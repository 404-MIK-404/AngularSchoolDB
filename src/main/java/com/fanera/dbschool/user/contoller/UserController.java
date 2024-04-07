package com.fanera.dbschool.user.contoller;


import com.fanera.dbschool.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/dbschool/user",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/test")
    public String testQuery(){
        userService.loadUserInfo("MIK");
        return "hello";
    }


}

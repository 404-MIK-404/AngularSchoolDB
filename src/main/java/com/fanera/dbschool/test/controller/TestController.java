package com.fanera.dbschool.test.controller;

import com.fanera.dbschool.app.entity.USER_SCHOOL;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/dbschool/test",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TestController {

    @GetMapping(value = "/hello")
    public String sayHelloFunc(){
        return "Hello " + ((USER_SCHOOL) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getLogin();
    }


}

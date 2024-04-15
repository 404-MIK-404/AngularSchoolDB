package com.fanera.dbschool.user.service;


import com.fanera.dbschool.app.entity.USER_SCHOOL;
import com.fanera.dbschool.app.service.JwtService;
import com.fanera.dbschool.app.service.UserSessionService;
import com.fanera.dbschool.user.repository.RedisUserRepositoryImpl;
import com.fanera.dbschool.user.repository.UserRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private UserSessionService userSessionService;

    public String signInUser(USER_SCHOOL user){
        USER_SCHOOL userFind = userRepository.findByLogin(user.getLogin());
        return userSessionService.loadUserInfo(user,userFind,jwtService.genToken(user.getLogin()));
    }

    public String signUpUser(USER_SCHOOL user){
        String res = userSessionService.addUser(user,jwtService.genToken(user.getLogin()));
        userRepository.save(user);
        return res;
    }

}

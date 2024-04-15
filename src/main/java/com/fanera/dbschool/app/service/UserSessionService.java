package com.fanera.dbschool.app.service;


import com.fanera.dbschool.app.entity.USER_SCHOOL;
import com.fanera.dbschool.user.repository.RedisUserRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserSessionService {

    private final RedisUserRepositoryImpl redisUserRepositoryImpl;

    private final PasswordEncoder passwordEncoder;

    public String addUser(USER_SCHOOL user,String id){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        redisUserRepositoryImpl.saveEntity(id,user);
        return id;
    }

    public String loadUserInfo(USER_SCHOOL user,USER_SCHOOL userFind,String id){
        if (passwordEncoder.matches(user.getPassword(),userFind.getPassword())){
            if (isHaveRecordById(id) == null){
                redisUserRepositoryImpl.saveEntity(id,user);
            }
        }
        return id;
    }


    public UserDetails find(String tk){
        return redisUserRepositoryImpl.findUserById(tk);
    }

    public Boolean isHaveRecordById(String id){
        return redisUserRepositoryImpl.findUserById(id) != null;
    }


}

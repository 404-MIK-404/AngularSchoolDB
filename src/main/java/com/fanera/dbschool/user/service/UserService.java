package com.fanera.dbschool.user.service;


import com.fanera.dbschool.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void loadUserInfo(String login){
        System.out.println(userRepository.findByLogin(login));
    }

}

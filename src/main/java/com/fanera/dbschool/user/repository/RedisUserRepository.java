package com.fanera.dbschool.user.repository;

import com.fanera.dbschool.app.entity.USER_SCHOOL;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface RedisUserRepository {

    void saveEntity(String id, UserDetails user);

    void delEntity(String id);

    UserDetails findUserById(String id);

}

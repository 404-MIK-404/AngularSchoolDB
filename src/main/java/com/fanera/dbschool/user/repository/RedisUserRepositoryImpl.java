package com.fanera.dbschool.user.repository;

import com.fanera.dbschool.app.config.RedisConfig;
import com.fanera.dbschool.app.entity.USER_SCHOOL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class RedisUserRepositoryImpl implements RedisUserRepository{

    private final RedisTemplate<String,Object> redisTemplate;

    private final RedisConfig redisConfig;

    private ValueOperations valueOperations;

    private final Gson gson = new GsonBuilder().create();

    @PostConstruct
    private void init(){
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void saveEntity(String id, UserDetails user) {
        valueOperations.set(id,gson.toJson(user),redisConfig.getTimeout(), TimeUnit.SECONDS);
    }

    @Override
    public void delEntity(String id) {
        valueOperations.getAndDelete(id);
    }

    @Override
    public UserDetails findUserById(String id) {
        return gson.fromJson((String) valueOperations.get(id),USER_SCHOOL.class);
    }

}

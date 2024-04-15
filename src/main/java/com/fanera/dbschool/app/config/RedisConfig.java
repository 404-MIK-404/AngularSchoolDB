package com.fanera.dbschool.app.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:redisdb.yml")
@ConfigurationProperties(prefix = "redis.setting-connection")
public class RedisConfig {

    @Value("${host}")
    private String HOST_REDIS;

    @Value("${port}")
    private int PORT_REDIS;

    @Value("${password}")
    private String PASSWORD_REDIS;

    @Value("${timeout-operation}")
    @Getter
    private Integer timeout;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName(HOST_REDIS);
        jedisConFactory.setPort(PORT_REDIS);
        jedisConFactory.setPassword(PASSWORD_REDIS);
        return jedisConFactory;
    }


    @Bean
    public <F,S> RedisTemplate<F, S> redisTemplate() {
        RedisTemplate<F, S> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }



}

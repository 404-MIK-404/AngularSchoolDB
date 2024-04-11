package com.fanera.dbschool.app.config;

import com.fanera.dbschool.app.filter.JwtFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@AllArgsConstructor
@PropertySource("classpath:application.properties")
@EnableWebSecurity
public class AppConfig {

    private final JwtFilter jwtFilter;
    @Bean
    public PasswordEncoder initPasswordEncode(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain initSecurityFilter(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(filter->{
                    filter.requestMatchers("/api/dbschool/user/**").permitAll();
                }).addFilterBefore(jwtFilter, BasicAuthenticationFilter.class);
        return http.build();
    }


}

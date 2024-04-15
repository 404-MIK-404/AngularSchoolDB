package com.fanera.dbschool.app.config;

import com.fanera.dbschool.app.filter.JwtFilter;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
@Data
@PropertySource("classpath:enviroment.school.yml")
@ConfigurationProperties(prefix = "security")
public class SecurityConfig {

    private SecretKey SECRET_KEY_CONF;

    public SecurityConfig(@Value("${secret}") String secret){
        byte[] con = Decoders.BASE64.decode(secret);
        SECRET_KEY_CONF = Keys.hmacShaKeyFor(con);
    }

    @Bean
    public PasswordEncoder initPasswordEncode(){
        return new BCryptPasswordEncoder();
    }


}

package com.fanera.dbschool.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Data
@Entity(name = "spr_user_school_role")
@Table(name = "spr_user_school_role")
@AllArgsConstructor
@NoArgsConstructor
public class SPR_USER_SCHOOL_ROLE implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    private String role;


    @Override
    public String getAuthority() {
        return this.role;
    }
}

package com.fanera.dbschool.user.repository;

import com.fanera.dbschool.app.entity.USER_SCHOOL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<USER_SCHOOL,Long> {

    @Query("SELECT userSchool FROM user_school AS userSchool WHERE userSchool.login=:login")
    USER_SCHOOL findByLogin(String login);

}

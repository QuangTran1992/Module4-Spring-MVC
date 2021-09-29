package com.codegym.repository;

import com.codegym.repository.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where phoneNumber=:phoneNumber and passwordHash=:passwordHash", nativeQuery = true)
    Optional<User> getUserByPhoneNumber(@Param("phoneNumber") String phoneNumber , @Param("passwordHash") String passwordHash);



}

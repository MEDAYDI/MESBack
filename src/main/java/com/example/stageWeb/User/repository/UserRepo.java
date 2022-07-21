package com.example.stageWeb.User.repository;

import com.example.stageWeb.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query("SELECT u from User u   where  u.username = ?1")
    User findUserByUsername(String username);
    Optional<User> findByEmail(String email);


    @Transactional
    @Modifying
    @Query("UPDATE User u set u.enable = true  where  u.email = ?1")
    int enableAppUser(String email);

    boolean existsByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE User u set u.password = ?1  where  u.username = ?2")
    int restPassword(String password,String username);


}

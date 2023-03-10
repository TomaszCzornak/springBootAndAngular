package com.example.springbootangularbook.user.repository;

import com.example.springbootangularbook.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query("" + "select case when count(u) >0 then " +
                 "true else false end " +
           " from UserEntity u "+
          "where u.email =?1")
    Boolean selectExistsEmail(String email);
    UserEntity  findByEmail(String email);
}

package com.example.springbootangularbook.user.repository;

import com.example.springbootangularbook.user.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @Test
    void itShouldCheckWhenUserEmailExists() {
        //give
        String email = "tomek@tomek.pl";
        UserEntity userEntity = new UserEntity(email,"21398732478");
        underTest.save(userEntity);
        //when
        boolean expected = underTest.selectExistsEmail(email);
        //then
        assertThat(expected).isTrue();
    }

}

package com.example.springbootangularbook.jwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest implements Serializable {

    private String email;
    private String password;
}

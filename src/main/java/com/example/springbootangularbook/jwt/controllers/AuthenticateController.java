package com.example.springbootangularbook.jwt.controllers;

import com.example.springbootangularbook.jwt.models.AuthenticationRequest;
import com.example.springbootangularbook.jwt.models.AuthenticationResponse;
import com.example.springbootangularbook.jwt.services.ApplicationUserDetailsService;
import com.example.springbootangularbook.jwt.utils.JwtUtil;
import com.example.springbootangularbook.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@AllArgsConstructor
class AuthenticateController {

    private final AuthenticationManager
            authenticationManager;
    private final JwtUtil jwtTokenUtil;
    private final ApplicationUserDetailsService
            userDetailsService;

    @RequestMapping(value = "/authenticate")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest req
    ) throws Exception {
        UserEntity user;
        try {
            user = userDetailsService.authenticate(
                    req.getEmail(), req.getPassword());
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password",
                    e);
        }
        var userDetails = userDetailsService.
                loadUserByUsername(user.getEmail());
        System.out.println(userDetails);
        var jwt = jwtTokenUtil.generateToken(userDetails);
        return new AuthenticationResponse(jwt);
    }

}
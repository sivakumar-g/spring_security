package com.roleauth.roleAuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roleauth.roleAuth.entity.JwtRequest;
import com.roleauth.roleAuth.entity.JwtResponse;
import com.roleauth.roleAuth.service.JwtService;

@RestController
@CrossOrigin
public class JwtController {


    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
    
}

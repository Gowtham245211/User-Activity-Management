package com.useractivitymanagement.controller;

import com.useractivitymanagement.entity.User;
import com.useractivitymanagement.repository.UserRepo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/signUp")
public class SignUp {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody @Valid User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        JSONObject json = new JSONObject();
        user.setEncryptedPassword(encoder.encode(user.getOriginalPassword()));
        userRepo.save(user);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}

package com.useractivitymanagement.controller;

import com.useractivitymanagement.entity.Comment;
import com.useractivitymanagement.entity.Profile;
import com.useractivitymanagement.entity.User;
import com.useractivitymanagement.repository.CommentRepo;
import com.useractivitymanagement.repository.UserRepo;
import com.useractivitymanagement.service.UserServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getUserByEmail")
    public ResponseEntity<User> getUserByEmail(@RequestParam("email") String email) {

        User user = userService.findByEmailEquals(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/updateUserByEmail")
    public ResponseEntity<String> updateUserByEmail(User user) {

        userService.updateUserByEmail(user.getEmail(), user.getUserName());
        return new ResponseEntity<>("Update successful", HttpStatus.OK);
    }
}

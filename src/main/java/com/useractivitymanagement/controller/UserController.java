package com.useractivitymanagement.controller;

import com.useractivitymanagement.entity.Comment;
import com.useractivitymanagement.entity.Profile;
import com.useractivitymanagement.entity.User;
import com.useractivitymanagement.repository.CommentRepo;
import com.useractivitymanagement.repository.UserRepo;
import com.useractivitymanagement.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getUserByEmail")
    @Operation(summary = "Used to get user object through email")
    @ApiResponse(responseCode = "200", description = "User obj received successfully")
    public ResponseEntity<User> getUserByEmail(HttpServletRequest request, @RequestParam("email") String email) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userId".equals(cookie.getName())) {
                    System.out.println(cookie.getValue());
                }
            }
        }
        User user = userService.findByEmailEquals(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/updateUserByEmail")
    @Operation(summary = "Used to update user object through email")
    @ApiResponse(responseCode = "201", description = "User updated successfully")
    public ResponseEntity<String> updateUserByEmail(User user) {

        userService.updateUserByEmail(user.getEmail(), user.getUserName());
        return new ResponseEntity<>("Update successful", HttpStatus.OK);
    }
}

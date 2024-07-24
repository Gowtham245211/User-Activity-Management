package com.useractivitymanagement.controller;

import com.useractivitymanagement.entity.Post;
import com.useractivitymanagement.entity.User;
import com.useractivitymanagement.exceptions.ErrorDetails;
import com.useractivitymanagement.exceptions.UserNotFoundException;
import com.useractivitymanagement.repository.PostRepo;
import com.useractivitymanagement.repository.UserRepo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    @PostMapping("/createPost")
    public ResponseEntity<String> createPost(@RequestBody @Valid Post post, User user) {

        JSONObject json = new JSONObject();
        post.setUser(userRepo.findByUserId(user.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found for the id")));
        postRepo.save(post);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}

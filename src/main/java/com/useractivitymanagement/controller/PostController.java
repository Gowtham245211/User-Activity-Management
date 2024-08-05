package com.useractivitymanagement.controller;

import com.useractivitymanagement.entity.Post;
import com.useractivitymanagement.entity.User;
import com.useractivitymanagement.exceptions.UserNotFoundException;
import com.useractivitymanagement.repository.PostRepo;
import com.useractivitymanagement.repository.UserRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/createPost")
    public ResponseEntity<String> createPost(@RequestBody @Valid Post post, User user) {

        JSONObject json = new JSONObject();
        post.setUser(userRepo.findByUserId(user.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found for the id")));
        postRepo.save(post);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }

    @GetMapping("/getPostByUserId")
    @Operation(summary = "Used to get posts through stored procedure by userid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Posts list received successfully"),
            @ApiResponse(responseCode = "404", description = "No posts available")
    })
    public ResponseEntity<String> getPostByUserId(String userId) {

        JSONObject json = new JSONObject();
        List resultList = entityManager
                .createNamedStoredProcedureQuery("firstProcedure")
                .setParameter("userId", userId)
                .getResultList();

        resultList.forEach(System.out::println);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}

package com.useractivitymanagement.controller;

import com.useractivitymanagement.entity.Comment;
import com.useractivitymanagement.repository.CommentRepo;
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
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepo commentRepo;

    @PostMapping("/createCommentPost")
    public ResponseEntity<String> createCommentPost(@RequestBody @Valid Comment comment) {

        JSONObject json = new JSONObject();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        comment.getPost().getUser().setEncryptedPassword(encoder.encode(comment.getPost().getUser().getOriginalPassword()));;
        commentRepo.save(comment);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}

package com.useractivitymanagement.controller;

import com.useractivitymanagement.entity.Comment;
import com.useractivitymanagement.entity.Tag;
import com.useractivitymanagement.repository.CommentRepo;
import com.useractivitymanagement.repository.TagRepo;
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
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagRepo tagRepo;

    @PostMapping("/createTag")
    public ResponseEntity<String> createTag(@RequestBody @Valid Tag tag) {

        JSONObject json = new JSONObject();
        tagRepo.save(tag);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}

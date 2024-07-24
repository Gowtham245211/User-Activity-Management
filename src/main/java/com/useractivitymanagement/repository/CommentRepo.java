package com.useractivitymanagement.repository;

import com.useractivitymanagement.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {


}

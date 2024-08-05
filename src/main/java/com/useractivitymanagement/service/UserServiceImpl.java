package com.useractivitymanagement.service;

import com.useractivitymanagement.entity.User;
import com.useractivitymanagement.exceptions.UserNotFoundException;
import com.useractivitymanagement.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig
public class UserServiceImpl {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepo userRepo;

    @Cacheable(cacheNames = "cache1", key = "#email")
    // @Cacheable(key = "#email", value = "User")
    public User findByEmailEquals(String email) {

        log.info("findByEmailEquals method entered");
        return userRepo.findByEmailEquals(email)
                .orElseThrow(() -> new UserNotFoundException("User not found for given email"));
    }

    @CachePut(cacheNames = "cache1", key = "#email")
    public void updateUserByEmail(String email, String username) {
        userRepo.updateByEmail(email, username);
    }

    // @CacheEvict(key = "#email",value = "User")
}


package com.pbuserservice.user.controller;

import com.pbuserservice.user.VO.ResponseTemplateVO;
import com.pbuserservice.user.entity.User;
import com.pbuserservice.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("*/")
    public User saveUser(@RequestBody  User user)
    {
        log.info("inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        return userService.getUserWithDepartment(userId);

    }
}

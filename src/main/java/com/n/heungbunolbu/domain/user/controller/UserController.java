package com.n.heungbunolbu.domain.user.controller;

import com.n.heungbunolbu.domain.user.model.entity.User;
import com.n.heungbunolbu.domain.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MemberController {

    
    private final UserService userService;


    @GetMapping("join")
    public String userJoin(@RequestBody User user){

    }
}

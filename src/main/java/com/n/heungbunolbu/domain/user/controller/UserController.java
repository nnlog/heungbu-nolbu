package com.n.heungbunolbu.domain.user.controller;

import com.n.heungbunolbu.domain.user.model.dto.UserDTO;
import com.n.heungbunolbu.domain.user.model.entity.User;
import com.n.heungbunolbu.domain.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 페이지로 이동
    @GetMapping("/join")
    public String joinForm(){
        return "user/joinForm";
    }

    // 회원가입
    @PostMapping("/join")
    public String userJoin(UserDTO userDTO){
        User user = userDTO.toEntity();
        userService.join(user);

        return "user/login";
    }

    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

    // 로그인
    @PostMapping("/login")
    public String userLogin(UserDTO userDTO){
        String email = userDTO.getUserEmail();
        String pw = userDTO.getUserPw();
        Optional<User> user = userService.getUserInfoByEmail(email);
        if(user.get().getUserPw().equals(pw)){
            return "home";
        }
        else {
            return "redirect:user/login";
        }

    }
}

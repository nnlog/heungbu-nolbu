package com.n.heungbunolbu.domain.user.controller;

import com.n.heungbunolbu.domain.user.model.dto.UserDTO;
import com.n.heungbunolbu.domain.user.model.entity.User;
import com.n.heungbunolbu.domain.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String userJoin(UserDTO userDTO) throws Exception{
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
    public String userLogin(@RequestParam("userEmail") String email,
                            @RequestParam("userPw") String pw,
                            Model model) throws Exception{
        String path="";
        Optional<User> user = userService.getUserInfoByEmail(email);
        if(user.get().getUserPw().equals(pw)){
            model.addAttribute("user", user.get());
            model.addAttribute("status", "true");
            path = "/home";
        }
        else {
            path = "redirect:/user/login";
        }

        return path;

    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest req) throws Exception{
        HttpSession session = req.getSession();
        session.invalidate();

        return "redirect:/";
    }
}

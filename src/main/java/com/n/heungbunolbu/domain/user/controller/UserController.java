package com.n.heungbunolbu.domain.user.controller;

import com.n.heungbunolbu.domain.user.model.dto.UserDTO;
import com.n.heungbunolbu.domain.user.model.entity.User;
import com.n.heungbunolbu.domain.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        String path="/home";
        User user = userService.getUserInfoByEmail(email).orElse(new User());

        UserDTO userDTO = new UserDTO(user);
        model.addAttribute("user", userDTO);
        model.addAttribute("status", "true");

        if(userDTO.getUserPw() == null || userDTO.getUserPw().equals("")){
            path = "redirect:/user/login";
        } else if(!userDTO.getUserPw().equals(pw)){
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

    // 이메일 찾기
    @GetMapping("/findEmail")
    public String findEmailForm(){
        return "/user/findEmailForm";
    }

    // 이메일 찾기
    @PostMapping("/findEmail")
    public String findEmail(@RequestParam String userName, @RequestParam String userPhone, Model model){
        List<User> users = userService.findEmail(userName, userPhone);

        List<UserDTO> userDTOList = users.stream().map(m -> new UserDTO(m)).collect(Collectors.toList());
        model.addAttribute("users", userDTOList);
        System.out.println(userDTOList);
        System.out.println(users);
        return "/user/findEmail";
    }
}

package com.n.heungbunolbu.domain.user.model.dto;


import com.n.heungbunolbu.domain.user.model.entity.User;
import lombok.Builder;
import lombok.Data;


@Data
public class UserDTO {

    public UserDTO(){}
    private String userName;
    private String userEmail;
    private String userPw;
    private String userPhone;
    private String userAdress;
    private String userJob;

    @Builder
    public UserDTO(String userName, String userEmail, String userPw, String userPhone, String userAdress, String userJob) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPw = userPw;
        this.userPhone = userPhone;
        this.userAdress = userAdress;
        this.userJob = userJob;
    }

    public UserDTO(User user){
        userName = user.getUserName();
        userEmail = user.getUserEmail();
        userPw = user.getUserPw();
        userPhone = user.getUserPhone();
        userAdress = user.getUserAdress();
        userJob = user.getUserJob();
    }

    public User toEntity(){
        User user = User.builder()
                .userName(userName)
                .userEmail(userEmail)
                .userPw(userPw)
                .userPhone(userPhone)
                .userAdress(userAdress)
                .userJob(userJob)
                .build();
        return user;
    }
}

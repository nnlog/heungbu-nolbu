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
        this.userName = user.getUserName();
        this.userEmail = user.getUserEmail();
        this.userPw = user.getUserPw();
        this.userPhone = user.getUserPhone();
        this.userAdress = user.getUserAdress();
        this.userJob = user.getUserJob();
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

package com.n.heungbunolbu.domain.user.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_pw")
    private String userPw;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_adress")
    private String userAdress;
    @Column(name = "user_job")
    private String userJob;

    @Builder
    public User(Long id, String userName, String userEmail, String userPw, String userPhone, String userAdress, String userJob) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPw = userPw;
        this.userPhone = userPhone;
        this.userAdress = userAdress;
        this.userJob = userJob;
    }

    public User() {

    }

    public void userUpdate(String userPw, String userPhone, String userAdress, String userJob){
        this.userPw = userPw;
        this.userPhone = userPhone;
        this.userAdress = userAdress;
        this.userJob = userJob;
    }
}

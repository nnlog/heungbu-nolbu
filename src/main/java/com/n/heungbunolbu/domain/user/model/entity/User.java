package com.n.heungbunolbu.domain.user.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member {
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


}

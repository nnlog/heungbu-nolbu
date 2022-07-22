package com.n.heungbunolbu.domain.user.repository;

import com.n.heungbunolbu.domain.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserNameAndUserPhone(String name, String phone);

    Optional<User> findByUserEmail(String email);


}

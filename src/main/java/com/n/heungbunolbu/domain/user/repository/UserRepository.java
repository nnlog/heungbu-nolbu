package com.n.heungbunolbu.domain.user.repository;

import com.n.heungbunolbu.domain.user.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserName(String name);

    Optional<Member> findByUserEmail(String email);


}
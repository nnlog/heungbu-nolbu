package com.n.heungbunolbu.domain.user.repository;

import com.n.heungbunolbu.domain.user.model.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    // 회원 가입
    Member save(Member member);

    // 회원 정보 업데이트

    // id로 회원 찾기
    Optional<Member> findById(Long id);

    // name으로 회원 찾기
    Optional<Member> findByName(String name);

    // email로 회원 찾기
    Optional<Member> findByEmail(String email);

    // 모든 회원 보기
    List<Member> findAll();
}

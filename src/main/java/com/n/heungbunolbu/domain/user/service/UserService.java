package com.n.heungbunolbu.domain.user.service;

import com.n.heungbunolbu.domain.user.model.entity.Member;
import com.n.heungbunolbu.domain.user.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member){
        // 중복 이메일 금지
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByUserEmail(member.getUserEmail());
        result.ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        });
    }

    // 비밀번호 변경


    // 전체 회원 조회
    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    // id로 회원 조회
    public Optional<Member> findOne(Long id){
        return memberRepository.findById(id);
    }
}

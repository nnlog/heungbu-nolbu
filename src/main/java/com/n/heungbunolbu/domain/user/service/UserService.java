package com.n.heungbunolbu.domain.user.service;

import com.n.heungbunolbu.domain.user.model.dto.UserDTO;
import com.n.heungbunolbu.domain.user.model.entity.User;
import com.n.heungbunolbu.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원 가입
    @Transactional
    public User join(User user){
        // 중복 이메일 금지
        validateDuplicateUser(user);
        return userRepository.save(user);
    }

    private void validateDuplicateUser(User user) {
        Optional<User> result = userRepository.findByUserEmail(user.getUserEmail());
        result.ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        });
    }

    // 비밀번호 변경


    // 전체 회원 조회
    public List<User> findAllMembers(){
        return userRepository.findAll();
    }

    // id로 회원 조회
    public Optional<User> getId(Long id){
        return userRepository.findById(id);
    }

    // email로 회원 조회
    public Optional<User> getUserInfoByEmail(String email){
        return userRepository.findByUserEmail(email);
    }
    // 회원 삭제
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    // 이메일 찾기
    public List<User> findEmail(String name, String phone){
        return userRepository.findByUserNameAndUserPhone(name, phone);
    }
}

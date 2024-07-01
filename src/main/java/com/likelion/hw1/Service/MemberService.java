package com.likelion.hw1.Service;

import com.likelion.hw1.Domain.DTO.RegisterRequestDTO;
import com.likelion.hw1.Domain.User.Member;
import com.likelion.hw1.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원가입
    public void createMember(RegisterRequestDTO dto) {
        Member newMember = new Member();
        newMember.setUserId(dto.getUserId());
        newMember.setPassword(dto.getPassword());
        newMember.setEmail(dto.getEmail());
        memberRepository.save(newMember);
    }

    // userId 받아서 userId, email 리턴하기
    public String getUserEmail(String userId) {
        Member selectedMember = memberRepository.findByUserId(userId);
        return selectedMember.getEmail();
    }

    // userId 받아서 email 수정하기
    public String patchEmail(String userId, RegisterRequestDTO dto) {
        Member email = memberRepository.findByUserId(userId);
        email.setEmail(dto.getEmail());
        memberRepository.save(email);
        return "";
    }

    // userId 받아서 유저 삭제하기
    public String deleteMember(String userId) {
        Member member = memberRepository.findByUserId(userId);
        memberRepository.delete(member);
        return "";
    }

    // userId 받아서 비밀번호 번경하기
    public String changePassword(String userId, RegisterRequestDTO dto) {
        Member password = memberRepository.findByUserId(userId); // userId에 맞는 password 가져오기
        password.changePassword(dto.getPassword());
        memberRepository.save(password);

        return "비밀번호 변경 완료";
    }
}

package com.likelion.hw1.Controller;

import com.likelion.hw1.Domain.DTO.RegisterRequestDTO;
import com.likelion.hw1.Repository.MemberRepository;
import com.likelion.hw1.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public Map<String, String> getUserId(@RequestBody RegisterRequestDTO dto) {
        memberService.createMember(dto);
        Map<String, String> userId = new HashMap<>();
        userId.put("userId", dto.getUserId());
        return userId;
    }

    @GetMapping
    public Map<String, String> getUserIdAndEmail(@RequestParam String userId) {
        Map<String, String> userIdAndEmail = new HashMap<>();
        userIdAndEmail.put("userId", userId);
        userIdAndEmail.put("email", memberService.getUserEmail(userId));
        return userIdAndEmail;
    }

    @PatchMapping
    public String patchEmail(@RequestParam String userId, @RequestBody RegisterRequestDTO dto) {
        return memberService.patchEmail(userId, dto);
    }

    @DeleteMapping("/{userId}")
    public String deleteMember(@PathVariable String userId) {
        return memberService.deleteMember(userId);
    }

    @PostMapping("/password")
    public String changePassword(@RequestParam String userId, @RequestBody RegisterRequestDTO dto) {
        return memberService.changePassword(userId, dto);
    }
}

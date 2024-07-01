package com.likelion.hw1.Repository;

import com.likelion.hw1.Domain.User.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserId(String userId);
}

package com.club.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.domain.Member;
@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {

}

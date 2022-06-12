package com.jd.domain2.repository;


import com.jd.domain2.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jaedoo Lee
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {}

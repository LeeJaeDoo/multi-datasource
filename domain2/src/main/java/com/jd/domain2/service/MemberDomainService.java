package com.jd.domain2.service;

import com.jd.domain2.entity.Member;
import com.jd.domain2.repository.MemberRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * @author Jaedoo Lee
 */
@Service
@RequiredArgsConstructor
public class MemberDomainService {

    private final MemberRepository memberRepository;

//    @Transactional(readOnly = true)
    public Member findBy(long id) {
        return memberRepository.findById(id).orElseThrow();
    }
}

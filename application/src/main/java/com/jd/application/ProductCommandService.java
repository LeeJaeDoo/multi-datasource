package com.jd.application;

//import com.jd.common.annotation.RedissonLock;
import com.jd.domain.entity.Product;
import com.jd.domain.repository.ProductRepository;
import com.jd.domain.service.ProductDomainService;
import com.jd.domain2.entity.Member;
import com.jd.domain2.repository.MemberRepository;
import com.jd.domain2.service.MemberDomainService;
import com.jd.exception.CommonException;;
//import com.jd.param.InvestorParam;
//import com.jd.service.ProductDomainService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * @author Jaedoo Lee
 */
@Service
@RequiredArgsConstructor
public class ProductCommandService {

//    private final ProductDomainService productDomainService;
    private final ProductRepository productRepository;
//    private final MemberDomainService memberDomainService;
    private final MemberRepository memberRepository;
//    private final ProductDomainService productDomainService;

//    @RedissonLock(key = "#param.productId")
//    public void investProducts(InvestorParam param) {
//        productDomainService.invest(param);
//    }

    @Transactional(transactionManager = "jtaTransactionManager")
    public void update() {
        Product product = productRepository.findById(1L).get();
        Member member = memberRepository.findById(1L).get();

        product.setTitle("new");
        member.setName("hello");
        productRepository.save(product);
        memberRepository.save(member);
    }

}

package com.jd.application;

//import com.jd.common.annotation.RedissonLock;
import com.jd.domain.entity.Product;
import com.jd.domain.service.ProductDomainService;
import com.jd.domain2.entity.Member;
import com.jd.domain2.service.MemberDomainService;;
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
//    private final ProductRepository productRepository;
    private final MemberDomainService memberDomainService;
//    private final MemberRepository memberRepository;
    private final ProductDomainService productDomainService;

//    @RedissonLock(key = "#param.productId")
//    public void investProducts(InvestorParam param) {
//        productDomainService.invest(param);
//    }

    @Transactional(transactionManager = "multiTransactionManager")
    public void update() {
        Product product = productDomainService.findBy(1L);
        Member member = memberDomainService.findBy(1L);

        product.setTitle("new");
        member.setName("hi");
    }

}

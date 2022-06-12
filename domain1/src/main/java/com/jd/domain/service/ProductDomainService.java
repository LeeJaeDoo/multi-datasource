package com.jd.domain.service;

import com.jd.domain.entity.Product;
import com.jd.domain.repository.ProductRepository;
import com.jd.exception.ErrorMessage;
import com.jd.exception.InvestorException;
import com.jd.param.InvestorParam;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * @author Jaedoo Lee
 */
@Service
@RequiredArgsConstructor
public class ProductDomainService {

    private final ProductRepository productRepository;

//    @Transactional(readOnly = true)
    public Product findBy(long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void invest(InvestorParam param) {
        Product product = productRepository.findById(param.getProductId())
                                           .orElseThrow(() -> new InvestorException(ErrorMessage.INVALID_PRODUCT_ID));

        product.validateInvesting(param.getInvestingAmount());
        product.addInvesting(param.toEntity(product));
    }

}

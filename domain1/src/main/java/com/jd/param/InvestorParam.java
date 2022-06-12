package com.jd.param;

import com.jd.domain.entity.Investor;
import com.jd.domain.entity.Product;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Jaedoo Lee
 */
@Getter
@Builder
public class InvestorParam {

    private final long userId;
    private final long productId;
    private final BigDecimal investingAmount;

    public Investor toEntity(Product product) {
        return Investor.builder()
                       .userId(userId)
                       .investedAmount(investingAmount)
                       .product(product)
                       .build();
    }

}

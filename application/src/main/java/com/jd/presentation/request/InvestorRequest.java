//package com.jd.presentation.request;
//
//
//import com.jd.param.InvestorParam;
//
//import java.math.BigDecimal;
//
//import javax.validation.constraints.DecimalMin;
//import javax.validation.constraints.NotNull;
//
//import lombok.Getter;
//import lombok.Setter;
//
///**
// * @author Jaedoo Lee
// */
//@Getter
//@Setter
//public class InvestorRequest {
//
//    @NotNull(message = "{product.investor.notNull.investimgAmount}")
//    @DecimalMin(value = "1", message = "{product.investor.decimalMin.investimgAmount}")
//    private BigDecimal investingAmount;
//
//    public InvestorParam toParam(long userId, long productId) {
//        return InvestorParam.builder()
//                            .userId(userId)
//                            .productId(productId)
//                            .investingAmount(investingAmount)
//                            .build();
//    }
//
//}

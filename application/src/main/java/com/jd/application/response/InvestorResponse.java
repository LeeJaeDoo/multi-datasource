//package com.jd.application.response;
//
//import com.jd.entity.Investor;
//import com.jd.util.CollectionUtils;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import lombok.Builder;
//import lombok.Getter;
//import lombok.experimental.ExtensionMethod;
//
///**
// * @author Jaedoo Lee
// */
//@Getter
//@Builder
//@ExtensionMethod(CollectionUtils.class)
//public class InvestorResponse {
//
//    private final long productId;
//    private final String productTitle;
//    private final BigDecimal totalInvestingAmount;
//    private final BigDecimal investedAmount;
//    private final LocalDateTime investedAt;
//
//    public static InvestorResponse of(Investor investor) {
//        return InvestorResponse.builder()
//                               .productId(investor.getProduct().getId())
//                               .productTitle(investor.getProduct().getTitle())
//                               .totalInvestingAmount(investor.getProduct().getTotalInvestingAmount())
//                               .investedAmount(investor.getInvestedAmount())
//                               .investedAt(investor.getCreatedAt())
//                               .build();
//    }
//
//    public static List<InvestorResponse> listOf(List<Investor> investor) {
//        return investor.map(InvestorResponse::of);
//    }
//
//}

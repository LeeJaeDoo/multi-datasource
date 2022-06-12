//package com.jd.application.response;
//
//import com.jd.entity.Product;
//import com.jd.util.CollectionUtils;
//
//import org.springframework.data.domain.Page;
//
//import java.math.BigDecimal;
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
//@ExtensionMethod({CollectionUtils.class})
//public class ProductResponse {
//
//    private final long id;
//    private final String title;
//    private final BigDecimal totalInvestingAmount;
//    private final BigDecimal investingAmount;
//    private final long investorCnt;
//    private final String status;
//    private final int period;
//
//    public static ProductResponse of(Product product) {
//        return ProductResponse.builder()
//                              .id(product.getId())
//                              .title(product.getTitle())
//                              .totalInvestingAmount(product.getTotalInvestingAmount())
//                              .investingAmount(product.getInvestingAmount())
//                              .investorCnt(product.getInvestorCnt())
//                              .status(product.getStatus().getDesc())
//                              .period(product.getPeriod())
//                              .build();
//    }
//
//    public static Page<ProductResponse> listOf(Page<Product> products) {
//        return products.map(ProductResponse::of);
//    }
//
//}

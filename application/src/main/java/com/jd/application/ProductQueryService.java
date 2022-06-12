//package com.jd.application;
//
//import com.jd.application.response.ProductResponse;
//import com.jd.repository.ProductRepository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//
//import lombok.RequiredArgsConstructor;
//
///**
// * @author Jaedoo Lee
// */
//
//@Service
//@RequiredArgsConstructor
//public class ProductQueryService {
//
////    private final ProductRepository productRepository;
////
////    @Transactional(readOnly = true)
////    public Page<ProductResponse> getTotalProducts(LocalDateTime startedAt, LocalDateTime finishedAt, Pageable pageable) {
////
////        return productRepository.findAllByStartedAtAfterAndFinishedAtBefore(startedAt, finishedAt, pageable)
////            .map(ProductResponse::of);
////    }
//
//}

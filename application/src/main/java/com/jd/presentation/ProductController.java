package com.jd.presentation;

import com.jd.application.ProductCommandService;
//import com.jd.application.ProductQueryService;
//import com.jd.application.response.ProductResponse;
//import com.jd.presentation.request.InvestorRequest;
//import com.jd.presentation.request.ProductRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * @author Jaedoo Lee
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Validated
public class ProductController {

//    private final ProductQueryService productQueryService;
    private final ProductCommandService productCommandService;

//    @GetMapping
//    public ResponseEntity<Page<ProductResponse>> getTotalProduct(@Valid ProductRequest request, Pageable pageable) {
//
//        return ResponseEntity.ok(productQueryService.getTotalProducts(request.getStartedAt(), request.getFinishedAt(), pageable));
//    }
//
//    @PutMapping("/{productId}/invest")
//    public ResponseEntity<Void> investProducts(long userHeaderId, @PathVariable @Min(1) long productId, @Valid InvestorRequest request) {
//        productCommandService.investProducts(request.toParam(userHeaderId, productId));
//
//        return ResponseEntity.noContent().build();
//    }

    @PutMapping
    public ResponseEntity<Void> update() {
        productCommandService.update();

        return ResponseEntity.noContent().build();
    }

}

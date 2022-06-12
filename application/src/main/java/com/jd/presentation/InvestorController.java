package com.jd.presentation;

//import com.jd.application.InvestorQueryService;
//import com.jd.application.response.InvestorResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * @author Jaedoo Lee
 */
@RestController
@RequestMapping("/investors")
@RequiredArgsConstructor
public class InvestorController {

//    private final InvestorQueryService investorQueryService;

//    @GetMapping
//    public ResponseEntity<List<InvestorResponse>> getInvestorsInfo(long userHeaderId) {
//
//        return ResponseEntity.ok(investorQueryService.getInvestedInfo(userHeaderId));
//    }

}

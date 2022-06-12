package com.jd.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Jaedoo Lee
 */
@Getter
@RequiredArgsConstructor
public enum InvestmentStatus {

    WAITING("대기중"),
    RECRUTING("모집중"),
    FINISHING("모집완료"),
    ;

    private final String desc;

}

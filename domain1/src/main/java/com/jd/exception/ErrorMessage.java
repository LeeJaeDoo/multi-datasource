package com.jd.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Jaedoo Lee
 */
@Getter
@RequiredArgsConstructor
public enum ErrorMessage {

    BAD_REQUEST("잘못된 요청입니다."),
    UNAUTHORIZED_REQUEST("권한이 없는 요청입니다."),
    INTERNAL_SERVER_ERROR("내부 시스템 오류입니다."),
    INVALID_USER_ID("해당 사용자의 투자 정보를 조회할 수 없습니다."),
    INVALID_PRODUCT_ID("존재하지 않는 투자 상품 입니다."),
    PRODUCT_SOLD_OUT("모집이 완료된 투자 상품입니다."),
    INVALID_INVESTING_AMOUNT("남은 모집금액을 초과하여 투자할 수 없습니다."),
    ;

    private final String message;

}

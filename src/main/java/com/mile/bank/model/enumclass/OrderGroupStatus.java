package com.mile.bank.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderGroupStatus {

    REGISTERED(0, "등록", "상품 등록 상태"),
    UNREGISTERED(1, "해지", "상품 해지 상태"),
    WAITING(2, "대기", "상품 대기 상태"),
    ORDERING(2, "주문", "주문상태"),
    COMPLETE(3, "완료", "완료상태"),
    CONFIRM(4, "확인", "확인상태")
    ;

    private Integer id;
    private String title;
    private String description;
}

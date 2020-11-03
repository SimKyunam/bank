package com.mile.bank.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderPaymentType {

    CASH(0, "현금", "현금 결제 수단"),
    CARD(1, "카드", "카드 결제 수단"),
    BANK_TRANSFER(2, "계좌이체", "계좌이체 결제 수단"),
    CHECK_CARD(3, "체크카드", "체크 결제 수단")
    ;

    private int id;
    private String title;
    private String description;
}

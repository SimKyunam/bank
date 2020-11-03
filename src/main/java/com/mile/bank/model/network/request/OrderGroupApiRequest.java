package com.mile.bank.model.network.request;

import com.mile.bank.model.enumclass.OrderGroupStatus;
import com.mile.bank.model.enumclass.OrderPaymentType;
import com.mile.bank.model.enumclass.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderGroupApiRequest {

    private Long id;

    private OrderGroupStatus status;

    private OrderType orderType;

    private String revAddress;

    private String revName;

    private OrderPaymentType paymentType;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private Long userId;

}

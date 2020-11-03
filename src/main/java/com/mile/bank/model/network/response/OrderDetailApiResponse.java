package com.mile.bank.model.network.response;

import com.mile.bank.model.enumclass.OrderGroupStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDetailApiResponse {

    @Enumerated(EnumType.STRING)
    private OrderGroupStatus status;

    private LocalDateTime arrivalDate;

    private int quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private Long orderGroupId;

    private Long itemId;

}

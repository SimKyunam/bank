package com.mile.bank.model.network.response;

import com.mile.bank.model.entity.OrderGroup;
import com.mile.bank.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOrderInfoApiResponse {

    private UserApiResponse userApiResponse;
}

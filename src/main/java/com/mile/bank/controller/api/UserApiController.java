package com.mile.bank.controller.api;

import com.mile.bank.controller.CrudController;
import com.mile.bank.model.entity.User;
import com.mile.bank.model.network.Header;
import com.mile.bank.model.network.request.UserApiRequest;
import com.mile.bank.model.network.response.UserApiResponse;
import com.mile.bank.model.network.response.UserOrderInfoApiResponse;
import com.mile.bank.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {

    @Autowired
    protected UserApiLogicService userApiLogicService;

    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id){
        return userApiLogicService.orderInfo(id);
    }
}

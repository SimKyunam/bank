package com.mile.bank.controller.api;

import com.mile.bank.controller.CrudController;
import com.mile.bank.model.entity.OrderGroup;
import com.mile.bank.model.network.request.OrderGroupApiRequest;
import com.mile.bank.model.network.response.OrderGroupApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

}

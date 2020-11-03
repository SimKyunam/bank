package com.mile.bank.controller.api;

import com.mile.bank.controller.CrudController;
import com.mile.bank.model.entity.OrderDetail;
import com.mile.bank.model.network.request.OrderDetailApiRequest;
import com.mile.bank.model.network.response.OrderDetailApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController extends CrudController<OrderDetailApiRequest, OrderDetailApiResponse, OrderDetail> {

}

package com.mile.bank.controller.api;

import com.mile.bank.controller.CrudController;
import com.mile.bank.model.entity.Item;
import com.mile.bank.model.network.request.ItemApiRequest;
import com.mile.bank.model.network.response.ItemApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}

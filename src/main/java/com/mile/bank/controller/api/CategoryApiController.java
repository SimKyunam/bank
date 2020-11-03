package com.mile.bank.controller.api;

import com.mile.bank.controller.CrudController;
import com.mile.bank.model.entity.Category;
import com.mile.bank.model.network.request.CategoryApiRequest;
import com.mile.bank.model.network.response.CategoryApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController extends CrudController<CategoryApiRequest, CategoryApiResponse , Category> {

}

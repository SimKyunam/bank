package com.mile.bank.controller.api;

import com.mile.bank.controller.CrudController;
import com.mile.bank.model.entity.AdminUser;
import com.mile.bank.model.network.request.AdminUserApiRequest;
import com.mile.bank.model.network.response.AdminUserApiResponse;
import com.mile.bank.model.network.request.AdminUserApiRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {

}

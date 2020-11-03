package com.mile.bank.controller.api;

import com.mile.bank.controller.CrudController;
import com.mile.bank.model.entity.Partner;
import com.mile.bank.model.network.request.PartnerApiRequest;
import com.mile.bank.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {

}

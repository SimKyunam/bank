package com.mile.bank.service;

import com.mile.bank.model.entity.Partner;
import com.mile.bank.model.network.Header;
import com.mile.bank.model.network.Pagination;
import com.mile.bank.model.network.request.PartnerApiRequest;
import com.mile.bank.model.network.response.PartnerApiResponse;
import com.mile.bank.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerApiLogicService extends BaseService<PartnerApiRequest, PartnerApiResponse, Partner> {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {

        PartnerApiRequest body = request.getData();

        Partner partner = Partner.builder()
                .name(body.getName())
                .status(body.getStatus())
                .address(body.getAddress())
                .callCenter(body.getCallCenter())
                .partnerNumber(body.getPartnerNumber())
                .businessNumber(body.getBusinessNumber())
                .ceoName(body.getCeoName())
                .registeredAt(body.getRegisteredAt())
                .unregisteredAt(body.getUnregisteredAt())
                .createdAt(body.getCreatedAt())
                .createdBy(body.getCreatedBy())
                .updatedAt(body.getUpdatedAt())
                .updatedBy(body.getUpdatedBy())
                .category(categoryRepository.getOne(body.getCategoryId()))
                .build()
                ;

        Partner newPartner = baseRepository.save(partner);

        return  Header.OK(response(newPartner));
    }

    @Override
    public Header<PartnerApiResponse> read(Long id) {

       return baseRepository.findById(id)
                .map(this::response)
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {

        PartnerApiRequest body = request.getData();

        return baseRepository.findById(body.getId())
                .map(partner -> {
                    partner.setName(body.getName())
                            .setStatus(body.getStatus())
                            .setAddress(body.getAddress())
                            .setCallCenter(body.getCallCenter())
                            .setPartnerNumber(body.getPartnerNumber())
                            .setBusinessNumber(body.getBusinessNumber())
                            .setCeoName(body.getCeoName())
                            .setRegisteredAt(body.getRegisteredAt())
                            .setUnregisteredAt(body.getUnregisteredAt())
                            .setCreatedAt(body.getCreatedAt())
                            .setCreatedBy(body.getCreatedBy())
                            .setUpdatedAt(body.getUpdatedAt())
                            .setUpdatedBy(body.getUpdatedBy())
                            .setCategory(categoryRepository.getOne(body.getCategoryId()));

                    return partner;
                })
                .map(setPartner -> baseRepository.save(setPartner))
                .map(this::response)
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {

        return baseRepository.findById(id)
                .map(partner -> {
                    baseRepository.delete(partner);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<List<PartnerApiResponse>> search(Pageable pageable) {
        Page<Partner> partners = baseRepository.findAll(pageable);

        List<PartnerApiResponse> partnerApiResponseList = partners.stream()
                .map(this::response)
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(partners.getTotalPages())
                .totalElements(partners.getTotalElements())
                .currentPage(partners.getNumber())
                .currentElements(partners.getNumberOfElements())
                .build();

        return Header.OK(partnerApiResponseList, pagination);
    }

    private PartnerApiResponse response(Partner partner){

        PartnerApiResponse body = PartnerApiResponse.builder()
                .id(partner.getId())
                .name(partner.getName())
                .status(partner.getStatus())
                .address(partner.getAddress())
                .callCenter(partner.getCallCenter())
                .partnerNumber(partner.getPartnerNumber())
                .businessNumber(partner.getBusinessNumber())
                .ceoName(partner.getCeoName())
                .registeredAt(partner.getRegisteredAt())
                .unregisteredAt(partner.getUnregisteredAt())
                .createdAt(partner.getCreatedAt())
                .createdBy(partner.getCreatedBy())
                .updatedAt(partner.getUpdatedAt())
                .updatedBy(partner.getUpdatedBy())
                .categoryId(partner.getCategory().getId())
                .build();

        return body;
    }
}

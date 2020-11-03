package com.mile.bank.service;

import com.mile.bank.model.entity.Item;
import com.mile.bank.model.network.Header;
import com.mile.bank.model.network.Pagination;
import com.mile.bank.model.network.request.ItemApiRequest;
import com.mile.bank.model.network.response.ItemApiResponse;
import com.mile.bank.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemApiLogicService extends BaseService<ItemApiRequest, ItemApiResponse, Item> {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {

        ItemApiRequest body = request.getData();

        Item item = Item.builder()
                .status(body.getStatus())
                .name(body.getName())
                .title(body.getTitle())
                .content(body.getContent())
                .price(body.getPrice())
                .brandName(body.getBrandName())
                .registeredAt(LocalDateTime.now())
                .partner(partnerRepository.getOne(body.getPartnerId()))
                .build();

        Item newItem = baseRepository.save(item);
        return Header.OK(response(newItem));
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(this::response)
                .map(Header::OK)
                .orElseGet(()-> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {

        ItemApiRequest body = request.getData();

        return baseRepository.findById(body.getId())
                .map(entityItem -> {
                    entityItem
                            .setStatus(body.getStatus())
                            .setName(body.getName())
                            .setTitle(body.getTitle())
                            .setContent(body.getContent())
                            .setPrice(body.getPrice())
                            .setBrandName(body.getBrandName())
                            .setRegisteredAt(body.getRegisteredAt())
                            .setUnregisteredAt(body.getUnregisteredAt())
                            ;
                    return entityItem;
                })
                .map(newEntityItem -> baseRepository.save(newEntityItem))
                .map(this::response)
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {

        return baseRepository.findById(id)
                .map(item -> {
                    baseRepository.delete(item);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<List<ItemApiResponse>> search(Pageable pageable) {

        Page<Item> items = baseRepository.findAll(pageable);

        List<ItemApiResponse> itemApiResponseList = items.stream()
                .map(this::response)
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(items.getTotalPages())
                .totalElements(items.getTotalElements())
                .currentPage(items.getNumber())
                .currentElements(items.getNumberOfElements())
                .build();

        return Header.OK(itemApiResponseList, pagination);
    }

    public ItemApiResponse response(Item item){
        ItemApiResponse body = ItemApiResponse.builder()
                .id(item.getId())
                .status(item.getStatus())
                .name(item.getName())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .brandName(item.getBrandName())
                .registeredAt(item.getRegisteredAt())
                .unregisteredAt(item.getUnregisteredAt())
                .partnerId(item.getPartner().getId())
                .build();

        return body;
    }
}

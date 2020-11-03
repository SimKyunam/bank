package com.mile.bank.service;

import com.mile.bank.model.entity.OrderDetail;
import com.mile.bank.model.network.Header;
import com.mile.bank.model.network.Pagination;
import com.mile.bank.model.network.request.OrderDetailApiRequest;
import com.mile.bank.model.network.response.OrderDetailApiResponse;
import com.mile.bank.repository.ItemRepository;
import com.mile.bank.repository.OrderGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailApiLogicService extends BaseService<OrderDetailApiRequest, OrderDetailApiResponse, OrderDetail> {

    @Autowired
    OrderGroupRepository orderGroupRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Header<OrderDetailApiResponse> create(Header<OrderDetailApiRequest> request) {

        OrderDetailApiRequest body = request.getData();

        OrderDetail orderDetail = OrderDetail.builder()
                .status(body.getStatus())
                .arrivalDate(body.getArrivalDate())
                .quantity(body.getQuantity())
                .totalPrice(body.getTotalPrice())
                .createdAt(body.getCreatedAt())
                .createdBy(body.getCreatedBy())
                .updatedAt(body.getUpdatedAt())
                .updatedBy(body.getUpdatedBy())
                .orderGroup(orderGroupRepository.getOne(body.getOrderGroupId()))
                .item(itemRepository.getOne(body.getItemId()))
                .build();

        OrderDetail newOrderDetail = baseRepository.save(orderDetail);

        return Header.OK(response(newOrderDetail));
    }

    @Override
    public Header<OrderDetailApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(this::response)
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }

    @Override
    public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request) {

        OrderDetailApiRequest body = request.getData();

        return baseRepository.findById(body.getId())
                .map(orderDetail -> {
                     orderDetail
                            .setStatus(body.getStatus())
                            .setArrivalDate(body.getArrivalDate())
                            .setQuantity(body.getQuantity())
                            .setTotalPrice(body.getTotalPrice())
                            .setCreatedAt(body.getCreatedAt())
                            .setCreatedBy(body.getCreatedBy())
                            .setUpdatedAt(body.getUpdatedAt())
                            .setUpdatedBy(body.getUpdatedBy())
                            .setOrderGroup(orderGroupRepository.getOne(body.getOrderGroupId()))
                            .setItem(itemRepository.getOne(body.getItemId()));

                    return orderDetail;
                })
                .map(changOrderDetail -> baseRepository.save(changOrderDetail))
                .map(this::response)
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {

        return baseRepository.findById(id)
            .map(orderDetail -> {
                baseRepository.delete(orderDetail);
                return Header.OK();
            })
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<List<OrderDetailApiResponse>> search(Pageable pageable) {

        Page<OrderDetail> orderDetails = baseRepository.findAll(pageable);
        List<OrderDetailApiResponse> orderDetailApiResponseList = orderDetails.stream()
                .map(this::response)
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(orderDetails.getTotalPages())
                .totalElements(orderDetails.getTotalElements())
                .currentPage(orderDetails.getNumber())
                .currentElements(orderDetails.getNumberOfElements())
                .build();

        return Header.OK(orderDetailApiResponseList, pagination);
    }

    private OrderDetailApiResponse response(OrderDetail orderDetail){

        OrderDetailApiResponse body = OrderDetailApiResponse.builder()
                .status(orderDetail.getStatus())
                .arrivalDate(orderDetail.getArrivalDate())
                .quantity(orderDetail.getQuantity())
                .totalPrice(orderDetail.getTotalPrice())
                .createdAt(orderDetail.getCreatedAt())
                .createdBy(orderDetail.getCreatedBy())
                .updatedAt(orderDetail.getUpdatedAt())
                .updatedBy(orderDetail.getUpdatedBy())
                .orderGroupId(orderDetail.getOrderGroup().getId())
                .itemId(orderDetail.getItem().getId())
                .build();

        return body;
    }
}

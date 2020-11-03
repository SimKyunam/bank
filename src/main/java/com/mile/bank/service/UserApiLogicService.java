package com.mile.bank.service;

import com.mile.bank.model.entity.OrderGroup;
import com.mile.bank.model.entity.User;
import com.mile.bank.model.enumclass.UserStatus;
import com.mile.bank.model.network.Header;
import com.mile.bank.model.network.Pagination;
import com.mile.bank.model.network.request.UserApiRequest;
import com.mile.bank.model.network.response.ItemApiResponse;
import com.mile.bank.model.network.response.OrderGroupApiResponse;
import com.mile.bank.model.network.response.UserApiResponse;
import com.mile.bank.model.network.response.UserOrderInfoApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserApiLogicService extends BaseService<UserApiRequest , UserApiResponse, User> {

    // 1. request data
    // 2. User 생성
    // 3. 생성된 데이터 -> UserApiResponse return

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. request data
        UserApiRequest userApiRequest = request.getData();

        // 2. User 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED)
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = baseRepository.save(user);

        // 3. 생성된 데이터 -> UserApiResponse return

        return Header.OK(response(newUser));
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        //id -> repository getOne, getById
        Optional<User> optional = baseRepository.findById(id);

        //user -> userApiResponse return
        return optional
                .map(this::response)
                .map(Header::OK)
                .orElseGet(
                        ()->Header.ERROR("데이터 없음")
                );
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

        // 1. data
        UserApiRequest userApiRequest = request.getData();

        // 2. id -> user 데이터를 찾고
        Optional<User> optional = baseRepository.findById(userApiRequest.getId());

        return optional.map(user ->{
            // 3. update
            // id
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt());
            return user;
        })
        .map(user -> baseRepository.save(user))             //update -> updateUser
        .map(updateUser -> response(updateUser))            //userApiResponse
        .map(Header::OK)
        .orElseGet(() -> Header.ERROR("데이터 없음"));

    }

    @Override
    public Header delete(Long id) {

        // 1. id -> repository -> user
        Optional<User> optional = baseRepository.findById(id);

        // 2. repository -> delete
        return optional.map(user -> {
            baseRepository.delete(user);
            return Header.OK();
        })
        .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<List<UserApiResponse>> search(Pageable pageable){
        Page<User> users = baseRepository.findAll(pageable);

        List<UserApiResponse> userApiResponseList = users.stream()
                .map(this::response)
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(users.getTotalPages())
                .totalElements(users.getTotalElements())
                .currentPage(users.getNumber())
                .currentElements(users.getNumberOfElements())
                .build();


        // List<UserApiResponse>
        // Header<List<UserApiResponse>>
        return Header.OK(userApiResponseList, pagination);
    }

    private UserApiResponse response(User user){
        //user -> userApiResponse
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header + data return
        return userApiResponse;
    }

    public Header<UserOrderInfoApiResponse> orderInfo(Long id){

        //user
        User user = baseRepository.getOne(id);
        UserApiResponse userApiResponse = response(user);

        //order Group
        List<OrderGroup> orderGroupList = user.getOrderGroupList();
        List<OrderGroupApiResponse> orderGroupApiResponseList = orderGroupList.stream()
                .map(orderGroup -> {
                    OrderGroupApiResponse orderGroupApiResponse = orderGroupApiLogicService.response(orderGroup);
                    //item api response
                    List<ItemApiResponse> itemApiResponseList = orderGroup.getOrderDetailList().stream()
                            .map(orderDetail -> orderDetail.getItem())
                            .map(item -> itemApiLogicService.response(item))
                            .collect(Collectors.toList());

                    orderGroupApiResponse.setItemApiResponseList(itemApiResponseList);
                    return orderGroupApiResponse;
                })
                .collect((Collectors.toList()));


        userApiResponse.setOrderGroupApiResponseList(orderGroupApiResponseList);

        UserOrderInfoApiResponse userOrderInfoApiResponse = UserOrderInfoApiResponse.builder()
                .userApiResponse(userApiResponse)
                .build();

        return Header.OK(userOrderInfoApiResponse);
        //item
//        List<Item> itemList = orderGroupList.stream()
//                .map(orderGroup -> ordergroup.get)

    }

}

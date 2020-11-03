package com.mile.bank.service;

import com.mile.bank.model.entity.Category;
import com.mile.bank.model.network.Header;
import com.mile.bank.model.network.Pagination;
import com.mile.bank.model.network.request.CategoryApiRequest;
import com.mile.bank.model.network.response.CategoryApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryApiLogicService extends BaseService<CategoryApiRequest, CategoryApiResponse, Category> {

    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {

        CategoryApiRequest data = request.getData();

        Category category = Category.builder()
                .type(data.getType())
                .title(data.getTitle())
                .createdAt(data.getCreatedAt())
                .createdBy(data.getCreatedBy())
                .updatedAt(data.getUpdatedAt())
                .updatedBy(data.getUpdatedBy())
                .build();

        Category newCategory = baseRepository.save(category);

        return Header.OK(response(newCategory));

    }

    @Override
    public Header<CategoryApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(this::response)
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터가 없음"));
    }

    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {

        CategoryApiRequest data = request.getData();

        return baseRepository.findById(data.getId())
                .map(category -> {
                    category.setType(data.getType())
                            .setTitle(data.getTitle())
                            .setCreatedAt(data.getCreatedAt())
                            .setCreatedBy(data.getCreatedBy())
                            .setUpdatedAt(data.getUpdatedAt())
                            .setUpdatedBy(data.getUpdatedBy())
                    ;
                    return category;
                })
                .map((setCategory) -> baseRepository.save(setCategory))
                .map(this::response)
                .map(Header::OK)
                .orElseGet(()->Header.ERROR("데이터가 없음"));

    }

    @Override
    public Header delete(Long id) {

        return baseRepository.findById(id)
                .map(category -> {
                    baseRepository.delete(category);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<List<CategoryApiResponse>> search(Pageable pageable){
        Page<Category> categories = baseRepository.findAll(pageable);

        List<CategoryApiResponse> categoryApiResponseList = categories.stream()
                .map(this::response)
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(categories.getTotalPages())
                .totalElements(categories.getTotalElements())
                .currentPage(categories.getNumber())
                .currentElements(categories.getNumberOfElements())
                .build();

        // List<UserApiResponse>
        // Header<List<UserApiResponse>>
        return Header.OK(categoryApiResponseList, pagination);
    }

    private CategoryApiResponse response(Category category){

        CategoryApiResponse body = CategoryApiResponse.builder()
                .id(category.getId())
                .type(category.getType())
                .title(category.getTitle())
                .createdAt(category.getCreatedAt())
                .createdBy(category.getCreatedBy())
                .updatedAt(category.getUpdatedAt())
                .updatedBy(category.getUpdatedBy())
                .build();

        return body;
    }

}

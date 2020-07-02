package com.cmrv.purchaseList.apibs.category.util;

import org.mapstruct.Mapper;

import com.cmrv.purchaseList.apibs.category.model.api.CategoryRequest;
import com.cmrv.purchaseList.apibs.category.model.api.CategoryResponse;
import com.cmrv.purchaseList.apibs.category.model.entity.Category;

@Mapper(componentModel = "spring")
public interface AbstractMapper {
	//AbstractMapper INSTANCE = Mappers.getMapper(AbstractMapper.class);
	Category MapToCategory(CategoryRequest categoryRequest);
	
	CategoryResponse MapToCategoryResponse(Category category);
	
	CategoryRequest MapToCategoryRequest(Category category);
}

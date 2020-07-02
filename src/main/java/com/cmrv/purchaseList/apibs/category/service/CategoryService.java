package com.cmrv.purchaseList.apibs.category.service;

import com.cmrv.purchaseList.apibs.category.model.api.CategoryRequest;
import com.cmrv.purchaseList.apibs.category.model.entity.Category;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {

	public Flux<Category> list(String mode);
	public Mono<Category> findById(String id);
	public Mono<Category> save(CategoryRequest categoryRequest);
	public Mono<Category> update(CategoryRequest categoryRequest);
	public Mono<Void> delete(String id);

}

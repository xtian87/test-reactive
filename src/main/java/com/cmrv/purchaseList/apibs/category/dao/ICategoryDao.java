package com.cmrv.purchaseList.apibs.category.dao;

import com.cmrv.purchaseList.apibs.category.model.entity.Category;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICategoryDao {

	public Flux<Category> findAll();
	public Mono<Category> findById(String id);
	public Mono<Category> save(Category category);
	public Mono<Void> deleteById(String id);
}

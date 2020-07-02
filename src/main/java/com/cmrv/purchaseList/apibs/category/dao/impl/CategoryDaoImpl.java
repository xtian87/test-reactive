package com.cmrv.purchaseList.apibs.category.dao.impl;

import org.springframework.stereotype.Component;

import com.cmrv.purchaseList.apibs.category.dao.ICategoryDao;
import com.cmrv.purchaseList.apibs.category.model.entity.Category;
import com.cmrv.purchaseList.apibs.category.repository.ICategoryRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CategoryDaoImpl implements ICategoryDao {

	private ICategoryRepository categoryRepository;
	
	@Override
	public Flux<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Mono<Category> findById(String id) {
		return categoryRepository.findById(id);
	}

	@Override
	public Mono<Category> save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return categoryRepository.deleteById(id);
	}

}

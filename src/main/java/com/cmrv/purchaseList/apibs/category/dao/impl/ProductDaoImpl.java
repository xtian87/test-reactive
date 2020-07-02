package com.cmrv.purchaseList.apibs.category.dao.impl;

import org.springframework.stereotype.Component;

import com.cmrv.purchaseList.apibs.category.dao.IProductDao;
import com.cmrv.purchaseList.apibs.category.model.entity.Product;
import com.cmrv.purchaseList.apibs.category.repository.IProductRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class ProductDaoImpl implements IProductDao{

	private IProductRepository productRepository;

	@Override
	public Flux<Product> findByCategory(String categoryId) {
		return productRepository.findByCategoryId(categoryId);
	}

}

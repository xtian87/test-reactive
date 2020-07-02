package com.cmrv.purchaseList.apibs.category.dao;

import com.cmrv.purchaseList.apibs.category.model.entity.Product;
import reactor.core.publisher.Flux;

public interface IProductDao {

	Flux<Product> findByCategory(String categoryId);

}

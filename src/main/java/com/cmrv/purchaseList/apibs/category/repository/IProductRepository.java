package com.cmrv.purchaseList.apibs.category.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.cmrv.purchaseList.apibs.category.model.entity.Product;
import reactor.core.publisher.Flux;

public interface IProductRepository extends ReactiveMongoRepository<Product, String> {

	Flux<Product> findByCategoryId(String categoryId);

}

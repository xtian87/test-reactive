package com.cmrv.purchaseList.apibs.category.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cmrv.purchaseList.apibs.category.model.entity.Category;

public interface ICategoryRepository extends ReactiveMongoRepository<Category, String> {

}

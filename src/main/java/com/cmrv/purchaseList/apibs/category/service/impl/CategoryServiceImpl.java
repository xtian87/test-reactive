package com.cmrv.purchaseList.apibs.category.service.impl;

import org.springframework.stereotype.Service;

import com.cmrv.purchaseList.apibs.category.dao.ICategoryDao;
import com.cmrv.purchaseList.apibs.category.dao.IProductDao;
import com.cmrv.purchaseList.apibs.category.model.api.CategoryRequest;
import com.cmrv.purchaseList.apibs.category.model.entity.Category;
import com.cmrv.purchaseList.apibs.category.service.CategoryService;
import com.cmrv.purchaseList.apibs.category.util.AbstractMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

	private final ICategoryDao categoryDao;
	private final IProductDao productDao;
	private final AbstractMapper abstractMapper;
	private static final String MODE_COMPLETE = "complete";
	
	@Override
	public Flux<Category> list(String mode) {
		
		return MODE_COMPLETE.equals(mode) 
				? categoryDao.findAll()
						.flatMap(category -> {
							return Flux.just(category)
									.doOnNext(log -> System.out.println("Entro aca"))
									.zipWith(productDao.findByCategory(category.getId()), (c, p) -> {
										c.addProduct(p);
										System.out.println("Entro aca 1");
										return c;
									});
						})						
				: categoryDao.findAll().doOnNext(log -> System.out.println("Entro aca 2"));
	}

	@Override
	public Mono<Category> findById(String id) {
		return categoryDao.findById(id);
	}

	@Override
	public Mono<Category> save(CategoryRequest categoryRequest) {
		return Mono.just(categoryRequest)
		.map(categoryReq -> abstractMapper.MapToCategory(categoryReq))
		.doOnSuccess(obj -> System.out.println(obj.getId()+"/"+obj.getName()))
		.flatMap(category -> categoryDao.save(category));
	}
	
	@Override
	public Mono<Category> update(CategoryRequest categoryRequest) {
		return categoryDao.findById(categoryRequest.getId())
				.map(category -> abstractMapper.MapToCategory(categoryRequest))
				.flatMap(category -> categoryDao.save(category));
	}

	@Override
	public Mono<Void> delete(String id) {
		return categoryDao.findById(id)
				.flatMap(category -> categoryDao.deleteById(id));
	}
}
package com.cmrv.purchaseList.apibs.category.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmrv.purchaseList.apibs.category.model.api.CategoryRequest;
import com.cmrv.purchaseList.apibs.category.model.api.CategoryResponse;
import com.cmrv.purchaseList.apibs.category.model.entity.Category;
import com.cmrv.purchaseList.apibs.category.service.CategoryService;
import com.cmrv.purchaseList.apibs.category.util.AbstractMapper;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

	private final CategoryService categoryService;
	private final AbstractMapper abstractMapper;
	
	@GetMapping("/{id}")
	public Mono<Category> findById(@PathVariable String id) {
		return categoryService.findById(id);
	}
	
	@GetMapping(value = {"/list", "/list/{mode}"})
	public Flux<Category> list(@PathVariable(required = false, value = "") String mode) {
		return categoryService.list(mode);
	}
	
	@PostMapping("/save")
	public Mono<ResponseEntity<CategoryResponse>> save(
			@RequestBody CategoryRequest categoryRequest) {
		return categoryService.save(categoryRequest)
				.map(category -> abstractMapper.MapToCategoryResponse(category))
				.flatMap(categoryResponse -> Mono.just(ResponseEntity.ok(categoryResponse)));
	}
	
	@PutMapping(path = "/update")
	public Mono<ResponseEntity<CategoryResponse>> update(
			@RequestBody CategoryRequest categoryRequest) {
		return categoryService.update(categoryRequest)
				.flatMap(objCategory -> Mono.just(ResponseEntity.ok(
						abstractMapper.MapToCategoryResponse(objCategory))));
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void> delete (@PathVariable String id) {
		return categoryService.delete(id);
	}
}

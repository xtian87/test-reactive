package com.cmrv.purchaseList.apibs.category.model.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Document(collection = "categories")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	private String id;
	private String name;
	private List<Product> products;
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
}

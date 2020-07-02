package com.cmrv.purchaseList.apibs.category.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;

@Document
@Data
public class Product {

	@Id
	private String id;
	
	@NonNull
	private String name;
	private String categoryId;
	private String status;
}

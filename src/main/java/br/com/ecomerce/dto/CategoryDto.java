package br.com.ecomerce.dto;

import br.com.ecomerce.model.Category;

public class CategoryDto {

	private Long id;
	private String name;
	
	public CategoryDto(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

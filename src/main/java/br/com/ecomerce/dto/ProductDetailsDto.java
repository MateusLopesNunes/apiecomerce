package br.com.ecomerce.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import br.com.ecomerce.model.Product;

public class ProductDetailsDto {
	
	@NotBlank
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private Integer quantityPerStock;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private BigDecimal value;
	
	public ProductDetailsDto(Product obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.quantityPerStock = obj.getQuantityPerStock();
		this.description = obj.getDescription();
		this.value = obj.getValue();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getQuantityPerStock() {
		return quantityPerStock;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getValue() {
		return value;
	}
}

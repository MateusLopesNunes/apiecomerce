package br.com.ecomerce.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

public class ProductFormDto {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private Integer quantityPerStock;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private BigDecimal value;

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

package br.com.ecomerce.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ProductFormDto {
	
	@NotBlank @Length(min = 5)
	private String name;
	
	@NotNull
	private Integer quantityPerStock;
	
	@NotBlank @Length(min = 5)
	private String description;
	
	@NotNull
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

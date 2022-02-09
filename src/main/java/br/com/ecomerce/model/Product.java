package br.com.ecomerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.ecomerce.dto.ProductFormDto;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer quantityPerStock;
	private String description;
	private LocalDateTime registrationData = LocalDateTime.now();
	private BigDecimal value;
	
	@Enumerated(EnumType.STRING)
	private Type situation = Type.NORMAL;
	
	@OneToMany(mappedBy = "product")
	private Set<Category> categories = new HashSet<>();
	
	public Product() {}

	public Product(Long id, String name, Integer quantityPerStock, String description, BigDecimal value) {
		this.id = id;
		this.name = name;
		this.quantityPerStock = quantityPerStock;
		this.description = description;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantityPerStock() {
		return quantityPerStock;
	}

	public void setQuantityPerStock(Integer quantityPerStock) {
		this.quantityPerStock = quantityPerStock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getRegistrationData() {
		return registrationData;
	}

	public void setRegistrationData(LocalDateTime registrationData) {
		this.registrationData = registrationData;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Type getSituation() {
		return situation;
	}

	public void setSituation(Type situation) {
		this.situation = situation;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	public Product dtoToModel(ProductFormDto obj) {
		this.name = obj.getName();
		this.quantityPerStock = obj.getQuantityPerStock();
		this.description = obj.getDescription();
		this.value = obj.getValue();
		return this;
	}
}

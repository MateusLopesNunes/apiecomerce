package br.com.ecomerce.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ecomerce.dto.ProductDetailsDto;
import br.com.ecomerce.dto.ProductFormDto;
import br.com.ecomerce.model.Product;
import br.com.ecomerce.repository.ProductRepository;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<ProductDetailsDto> findAllProducts() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(ProductDetailsDto::new).collect(Collectors.toList());
	}
	
	@PostMapping
	public ResponseEntity saveProduct(@RequestBody @Valid ProductFormDto obj, UriComponentsBuilder uriBuilder) {
		Product product = new Product();
		product.dtoToModel(obj);
		productRepository.save(product);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDetailsDto> findByProduct(@PathVariable Long id) {
		Optional<Product> product = productRepository.findById(id);
		
		if (product.isPresent()) {
			return ResponseEntity.ok(new ProductDetailsDto(product.get()));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable Long id) {
		Optional<Product> product = productRepository.findById(id);
		
		if (product.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

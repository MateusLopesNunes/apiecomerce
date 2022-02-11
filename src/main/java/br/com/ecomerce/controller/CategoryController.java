package br.com.ecomerce.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ecomerce.dto.CategoryDto;
import br.com.ecomerce.dto.CategoryFormDto;
import br.com.ecomerce.dto.ProductDetailsDto;
import br.com.ecomerce.model.Category;
import br.com.ecomerce.model.Product;
import br.com.ecomerce.repository.CategoryRepository;

@RestController
@RequestMapping("category")
public class CategoryController {

	@Autowired
	public CategoryRepository categoryRepository;
	
	@GetMapping
	public List<CategoryDto> listCategory() {
		List<Category> category = categoryRepository.findAll();
		return category.stream().map(CategoryDto::new).collect(Collectors.toList());
	}
	
	@Transactional
	@PostMapping
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryFormDto obj, UriComponentsBuilder uriBuilder) {
		Category category = new Category();
		category.dtoToModel(obj);
		categoryRepository.save(category);
		
		URI uri = uriBuilder.path("category/{id}").buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created(uri).body(new CategoryDto(category));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findByProduct(@PathVariable Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		
		if (category.isPresent()) {
			return ResponseEntity.ok(new CategoryDto(category.get()));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable Long id) {
		Optional<Category> category = categoryRepository.findById(id);

		if (category.isPresent()) {
			categoryRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateProduct(@PathVariable Long id, @RequestBody CategoryFormDto obj) {
		Optional<Category> category = categoryRepository.findById(id);

		if (category.isPresent()) {
			category.get().dtoToModel(obj);
			categoryRepository.save(category.get());
			return ResponseEntity.ok(new CategoryDto(category.get()));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/name/{productName}")
	public ResponseEntity<List<CategoryDto>> findByName(@PathVariable String productName) {
		Optional<List<Category>> product = categoryRepository.findByName(productName);
		
		if(product.isPresent()) {
			List<CategoryDto> dto = product.get().stream().map(CategoryDto::new).collect(Collectors.toList());
			return ResponseEntity.ok(dto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

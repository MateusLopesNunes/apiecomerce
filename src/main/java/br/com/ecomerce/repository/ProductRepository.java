package br.com.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecomerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}

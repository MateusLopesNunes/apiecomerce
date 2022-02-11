package br.com.ecomerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ecomerce.model.Category;
import br.com.ecomerce.model.Product;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("select c from Category c where c.name like %:name%")
	Optional<List<Category>> findByName(@Param("name") String name);
}

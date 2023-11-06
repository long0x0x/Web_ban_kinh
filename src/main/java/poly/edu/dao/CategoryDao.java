package poly.edu.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
	@Query("SELECT o FROM Category o WHERE o.categoryname LIKE ?1")
	Page<Category> findByKeywords(String keywords, Pageable pageable);
	
	Optional<Category> findByCategoryname(String categoryName);
}

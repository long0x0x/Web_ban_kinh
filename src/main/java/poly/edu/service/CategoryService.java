package poly.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import poly.edu.entity.Category;

public interface CategoryService {

	void deleteAll();

	void deleteAll(List<Category> entities);

	void deleteAllById(List<Integer> ids);

	void delete(Category entity);

	void deleteById(Integer id);

	long count();

	boolean existsById(Integer id);

	Optional<Category> findById(Integer id);

	List<Category> findAllById(List<Integer> ids);

	List<Category> findAll();

	Page<Category> findAll(Pageable pageable);

	List<Category> saveAll(List<Category> entities);

	Category save(Category entity);
	
	Optional<Category> findByName(String categoryName);

}

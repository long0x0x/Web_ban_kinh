package poly.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poly.edu.dao.ProductDao;
import poly.edu.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	@Override
	public Product save(Product entity) {
		return productDao.save(entity);
	}

	@Override
	public List<Product> saveAll(List<Product> entities) {
		return (List<Product>)productDao.saveAll(entities);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productDao.findAll(pageable);
	}
	
	@Override
	public List<Product> findAll() {
		return (List<Product>)productDao.findAll();
	}

	@Override
	public List<Product> findAllById(List<Integer> ids) {
		return (List<Product>)productDao.findAllById(ids);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productDao.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return productDao.existsById(id);
	}

	@Override
	public long count() {
		return productDao.count();
	}

	@Override
	public void deleteById(Integer id) {
		productDao.deleteById(id);
	}

	@Override
	public void delete(Product entity) {
		productDao.delete(entity);
	}

	@Override
	public void deleteAllById(List<Integer> ids) {
		productDao.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Product> entities) {
		productDao.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productDao.deleteAll();
	}

	
	
}

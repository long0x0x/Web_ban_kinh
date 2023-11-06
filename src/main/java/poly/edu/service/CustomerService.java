package poly.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import poly.edu.entity.Customer;

public interface CustomerService {

	void deleteAll();

	void deleteAll(List<Customer> entities);

	void deleteAllById(List<String> ids);

	void delete(Customer entity);

	void deleteById(String id);

	long count();

	List<Customer> findAllById(List<String> ids);

	List<Customer> findAll();

	boolean existsById(String id);

	Optional<Customer> findById(String id);

	List<Customer> saveAll(List<Customer> entities);

	Customer save(Customer entity);

    boolean checkLogin(String uername, String password);

	Page<Customer> findAll(Pageable pageable);

}

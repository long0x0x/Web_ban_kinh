package poly.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import poly.edu.entity.Account;

public interface  AccountService {

	boolean checkLogin(String username, String password);

	void deleteAll();

	void deleteAll(List<Account> entities);

	void deleteAllById(List<String> ids);

	void delete(Account entity);

	void deleteById(String id);

	long count();

	List<Account> findAllById(List<String> ids);

	List<Account> findAll();

	Page<Account> findAll(Pageable pageable);

	boolean existsById(String id);

	Optional<Account> findById(String id);

	List<Account> saveAll(List<Account> entities);

	Account save(Account entity);

}

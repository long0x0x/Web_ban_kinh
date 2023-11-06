package poly.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poly.edu.dao.CustomerDao;
import poly.edu.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	 CustomerDao customerDao;

	@Override
	public Customer save(Customer entity) {
		return customerDao.save(entity);
	}

	@Override
	public List<Customer> saveAll(List<Customer> entities) {
		return (List<Customer>)customerDao.saveAll(entities);
	}

	@Override
	public Optional<Customer> findById(String id) {
		return customerDao.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return customerDao.existsById(id);
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return customerDao.findAll(pageable);
	}

	@Override
	public List<Customer> findAll( ) {
		return (List<Customer>)customerDao.findAll();
	}

	@Override
	public List<Customer> findAllById(List<String> ids) {
		return (List<Customer>)customerDao.findAllById(ids);
	}

	@Override
	public long count() {
		return customerDao.count();
	}

	@Override
	public void deleteById(String id) {
		customerDao.deleteById(id);
	}

	@Override
	public void delete(Customer entity) {
		customerDao.delete(entity);
	}

	@Override
	public void deleteAllById(List<String> ids) {
		customerDao.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Customer> entities) {
		customerDao.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		customerDao.deleteAll();
	}
	
	@Override
	public boolean checkLogin(String customername, String password) {
		Optional<Customer> optionalCustomer = findById(customername);
		if (optionalCustomer.isPresent() && optionalCustomer.get().getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}
	
	
}

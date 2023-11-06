package poly.edu.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, String>{
	@Query("SELECT o FROM Customer o WHERE o.customername LIKE ?1")
	Page<Customer> findByKeywords(String keywords, Pageable pageable);
}

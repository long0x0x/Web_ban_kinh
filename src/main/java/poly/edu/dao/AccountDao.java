package poly.edu.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.entity.Account;

public interface AccountDao extends JpaRepository<Account, String>{
	@Query("SELECT o FROM Account o WHERE o.username LIKE ?1")
	Page<Account> findByKeywords(String keywords, Pageable pageable);
}

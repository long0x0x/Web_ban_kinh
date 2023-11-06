package poly.edu.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer orderid;
	Double amount;
	@Column(columnDefinition = "nvarchar(100)")
	String address;
	@Temporal(TemporalType.DATE)
	@Column(name = "orderdate")
	Date createDate = new Date();
	
	@ManyToOne
	@JoinColumn(name = "customername")
	Customer customer;
	
	
	@OneToMany(mappedBy = "order")	
	Set<OrderDetail> orderdetails;
	
}

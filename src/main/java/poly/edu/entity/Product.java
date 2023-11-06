package poly.edu.entity;

import java.io.Serializable;
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
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Integer productid;
	@Column(columnDefinition = "nvarchar(100)")
	String name;
	@Column(columnDefinition = "varchar(225)")
	String image;
	Double price;
	Integer qty = 1;
    Double discount;
    @Column(columnDefinition = "nvarchar(300)")
    String description;
   
	@ManyToOne
	@JoinColumn(name = "categoryid")
	Category category;
	
	@OneToMany(mappedBy = "product")
	Set<OrderDetail> orderdetails;

	
	
}

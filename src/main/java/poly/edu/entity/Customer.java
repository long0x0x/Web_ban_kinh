package poly.edu.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Customers")
public class Customer implements Serializable {
	@Id
	@NotEmpty(message = "Username not empty")
	@Column(columnDefinition = "varchar(30)")
	private String customername;
	
	@NotEmpty(message = "Password not empty")
	@Size(min = 6, message = "Password tu 6 ki tu tro len")
	@Column(columnDefinition = "varchar(30)")
	private String password;
	
	@NotEmpty(message = "Fullname not empty")
	@Column(columnDefinition = "nvarchar(70)")
	private String fullname;
	
	@NotEmpty(message = "Email not empty")
	@Email(message = "Email khong dung dinh dang")
	@Column(columnDefinition = "varchar(130)")
	private String email;
	
	@NotEmpty(message = "Phone not empty")
	@Column(columnDefinition = "varchar(10)")
	private String phone;
	
	
	@OneToMany(mappedBy = "customer")
	Set<Order> orders;
}
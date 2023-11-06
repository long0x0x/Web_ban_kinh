package poly.edu.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Categorys")
public class Category implements Serializable {
	@Id
	Integer categoryid;
	@NotEmpty(message = "name not empty")
	@Column(columnDefinition = "nvarchar(100)")
	String categoryname;
	
	@OneToMany(mappedBy = "category")
	Set<Product> products ;
	
}

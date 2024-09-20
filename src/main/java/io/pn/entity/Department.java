package io.pn.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
@Table(name="dept")
public class Department {
	
	@Id
	@Column(name = "deptno",length = 2)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer departmentNo;
	
	@Column(name = "dname",length = 14)
	private String departmentName;
	
	@Column(name = "loc",length = 13)
	private String location;

//  To solve recursive problems in serialization for infinite data 
//	@JsonManagedReference
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private Set<Employee> employees;

	// The default constructor only exists for the sake of JPA.
    // You won’t use it directly, so it is designated as protected.
	protected Department() {
		
	}		
}

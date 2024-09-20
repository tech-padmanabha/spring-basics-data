package io.pn.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "emp")
public class Employee {

	@Id
	@Column(name = "empno", length = 4)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;

	@Column(name = "ename", length = 20)
	private String empName;

	@Column(name = "job", length = 9)
	private String job;

	@Column(name = "mgr", length = 4)
	private Integer manager;

	@Column(name = "hiredate")
	private LocalDate hireDate;

	@Column(name = "sal", precision = 7, scale = 2)
	private BigDecimal salary;

	@Column(name = "comm", precision = 7, scale = 2)
	private BigDecimal commission;

//	@JsonBackReference // If we use Entity directly as dto then we can use
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "deptno")
	private Department department;

	protected Employee() {
		
	}
}

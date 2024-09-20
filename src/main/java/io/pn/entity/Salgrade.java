package io.pn.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "salgrade")
public class Salgrade {
	
	@Id
	@Column(name = "grade")
	private Integer gradeNo;
	@Column(name = "losal",precision = 7,scale = 2)
	private BigDecimal lowSalary;
	@Column(name = "hisal",precision = 7,scale = 2)
	private BigDecimal highSalary;
	
}

package io.pn.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table
public class Teachers extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Double fee;
	
	// In other side you should use mapped by
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teacher_courses",
	   joinColumns = @JoinColumn(name="teacher_id"),
	   inverseJoinColumns = @JoinColumn(name="course_id"))
	private List<Courses> courses;
}

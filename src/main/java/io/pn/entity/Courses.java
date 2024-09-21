package io.pn.entity;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String subject;
	
	@ElementCollection
	@JoinTable(name = "teaching_timings"
			   ,joinColumns =@JoinColumn(name="id") )
	private List<LocalTime> timings;
	
	@ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
	private List<Teachers> teachers;
}

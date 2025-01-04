package io.pn.entity;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String subject;
	
	@ElementCollection
	@JoinTable(name = "teaching_timings"
			   ,joinColumns =@JoinColumn(name="id") )
	private List<LocalTime> timings;
	
	@ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
	private List<Teachers> teachers;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "backlog_id",referencedColumnName = "id")
	private BookLog bookLog;
}

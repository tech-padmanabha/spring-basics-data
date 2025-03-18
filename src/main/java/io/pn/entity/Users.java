package io.pn.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID userId;
	private String username;
	private String password;
	private boolean active;

	// helping use to create uni-directional table directly
	@ElementCollection(fetch = FetchType.EAGER)
	// we can define table name with join column name/details
	@JoinTable(name = "roles",joinColumns = @JoinColumn(name="user_id"))
	// we can provide replacement of @JoinTable but column name we can't defined here
	//@CollectionTable(name = "roles")

	// provide column name in table
	@Column(name = "role")

	// Default order is ASC
	@OrderBy(value = "user_role_order DESC")
	@OrderColumn(name = "user_role_order")
	private List<String> roles;
}

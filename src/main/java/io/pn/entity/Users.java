package io.pn.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
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
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "roles",joinColumns = @JoinColumn(name="user_id"))
	private List<String> roles;
}

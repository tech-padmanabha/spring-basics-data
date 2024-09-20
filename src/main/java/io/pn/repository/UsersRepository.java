package io.pn.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.pn.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
	
	Optional<Users>  findByUserIdAllIgnoreCase(UUID uuid);
	
}

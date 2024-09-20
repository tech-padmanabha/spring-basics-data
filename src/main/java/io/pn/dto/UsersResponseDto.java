package io.pn.dto;

import java.util.List;
import java.util.UUID;

public record UsersResponseDto(
		 UUID userId,
		 String username,
		 String password,
		 boolean active,
		 List<String> roles
		) {

}

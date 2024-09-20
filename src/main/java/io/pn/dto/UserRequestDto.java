package io.pn.dto;

import java.util.List;

public record UserRequestDto(
		 String username,
		 String password,
		 List<String> roles
		) {
}

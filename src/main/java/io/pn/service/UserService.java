package io.pn.service;

import io.pn.dto.UserRequestDto;
import io.pn.dto.UsersResponseDto;

public interface UserService {
	UsersResponseDto saveUsers(UserRequestDto users);
	UsersResponseDto searchByUserId(String uuid);
}

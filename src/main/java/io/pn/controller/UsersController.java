package io.pn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.pn.dto.UserRequestDto;
import io.pn.dto.UsersResponseDto;
import io.pn.service.UserServiceImpl;

@RestController
public class UsersController {

	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/store")
	public UsersResponseDto saveUser(@RequestBody UserRequestDto users) {
		return userService.saveUsers(users);
	}
	@GetMapping("/get")
	public UsersResponseDto findById(@RequestParam String id) {
		
		return userService.searchByUserId(id);
	}
}

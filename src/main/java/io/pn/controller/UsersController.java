package io.pn.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.pn.dto.UserRequestDto;
import io.pn.dto.UsersResponseDto;
import io.pn.service.UserService;

@Tag(name = "User",description = "User Control Point")
@RestController
public class UsersController {

	@Autowired
	private UserService userService;

	@Operation(summary = "Here we define the Users to store User")
	@PostMapping("/store")
	public UsersResponseDto saveUser(@RequestBody UserRequestDto users) {
		return userService.saveUsers(users);
	}

	@Operation(summary = "Get User Details By Id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched data Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UsersResponseDto.class))
			}),
			@ApiResponse(responseCode = "204" , description = "Content Not available"),
			@ApiResponse(responseCode = "400", description = "Bed request"),
			@ApiResponse(responseCode = "500", description = "Internal Server error")
		}
	)
	@GetMapping("/get")
	public UsersResponseDto findById(@RequestParam String id) {
		
		return userService.searchByUserId(id);
	}
}

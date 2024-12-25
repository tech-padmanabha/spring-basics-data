package io.pn.service.impls;

import java.lang.module.ResolutionException;
import java.util.UUID;

import io.pn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.pn.dto.UserRequestDto;
import io.pn.dto.UsersResponseDto;
import io.pn.entity.Users;
import io.pn.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository usersRepo;
	
	
	public UsersResponseDto saveUsers(UserRequestDto users){
		
		Users user = usersRepo.save(convertToUser(users));
		
		return convertToDto(user);
	}
	public UsersResponseDto searchByUserId(String uuid) {
		UsersResponseDto userDto = null;
		UUID fromData = UUID.fromString(uuid);
		Users users = usersRepo.findByUserIdAllIgnoreCase(fromData).orElseThrow(()-> new ResolutionException("User Not available"));
		userDto = convertToDto(users);
		return userDto;
	}
	
	private Users convertToUser(UserRequestDto userD) {
		Users user = new Users();
		user.setActive(true);
		user.setUsername(userD.username());
		user.setPassword(userD.password());
		user.setRoles(userD.roles());
		return user;
	}

	private UsersResponseDto convertToDto(Users user) {
		return new UsersResponseDto(
				user.getUserId(),
				user.getUsername(),
				user.getPassword(),
				user.isActive(),
				user.getRoles());
	}
}

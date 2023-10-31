package org.example.api;


import java.util.List;
import org.example.model.UserRequestDto;
import org.example.model.UserResponseDto;

public interface  UserService {
	List<UserResponseDto> getAllUsers();

	UserResponseDto getUserById(long userId);

	UserResponseDto createUser(UserRequestDto userDto);

	UserResponseDto updateUser(UserRequestDto userDto);

	Boolean deleteUser(long userId);
}

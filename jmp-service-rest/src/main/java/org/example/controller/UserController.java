package org.example.controller;

import java.util.List;
import org.example.model.UserRequestDto;
import org.example.model.UserResponseDto;

public interface UserController {
	List<UserResponseDto> getAllUser();
	UserResponseDto getUserById(long userId);
	UserResponseDto createUser(UserRequestDto userDto);
	UserResponseDto updateUser(UserRequestDto userDto);
	Boolean deleteUser(long userId);
}

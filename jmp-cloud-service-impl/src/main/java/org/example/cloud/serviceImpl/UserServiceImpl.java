package org.example.cloud.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.example.api.UserService;
import org.example.cloud.converter.RequestDtoToUserConverter;
import org.example.cloud.converter.UserToResponseDtoConverter;
import org.example.cloud.repository.UserRepository;
import org.example.model.User;
import org.example.model.UserRequestDto;
import org.example.model.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	private  RequestDtoToUserConverter toUserConverter;
	private  UserToResponseDtoConverter toDtoConverter;

	@Override
	public List<UserResponseDto> getAllUsers() {
		final List<User> allUsers = userRepository.getAllUsers();
		return allUsers.stream()
			.map(user -> toDtoConverter.convert(user))
			.collect(Collectors.toList());
	}

	@Override
	public UserResponseDto getUserById(long id) {
		final User userFomDb = userRepository.getUserById(id);

		return toDtoConverter.convert(userFomDb);
	}

	@Override
	public UserResponseDto createUser(UserRequestDto requestDto) {
		User userFromRequest = toUserConverter.convert(requestDto);

		userRepository.createUser(userFromRequest);

		return toDtoConverter.convert(userFromRequest);
	}

	@Override
	public UserResponseDto updateUser(UserRequestDto requestDto) {
		User userFromRequest = toUserConverter.convert(requestDto);

		if (userRepository.isExistsById(userFromRequest.getId())) {
			userRepository.updateUser(userFromRequest);
		}else
			throw new IllegalStateException(String.format("User to update with id = %s is not present in DB", userFromRequest.getId()));

		return toDtoConverter.convert(userFromRequest);
	}

	@Override
	public Boolean deleteUser(long id) {
		if (userRepository.isExistsById(id)) {
			userRepository.deleteUser(id);
		}else
			throw new IllegalStateException(String.format("User to delete with id = %s is not present in DB", id));

		return true;
	}
}

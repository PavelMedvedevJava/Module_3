package org.example.cloud.converter;


import org.example.model.User;
import org.example.model.UserResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToResponseDtoConverter implements Converter<User, UserResponseDto> {
	@Override
	public UserResponseDto convert(User user) {
		return UserResponseDto.builder()
			.id(user.getId())
			.name(user.getName())
			.surname(user.getSurname())
			.birthday(user.getBirthDate().toString())
			.build();
	}
}

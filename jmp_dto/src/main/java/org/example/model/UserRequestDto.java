package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
	private Long id;
	private String name;
	private String surname;
	private String birthday;
}

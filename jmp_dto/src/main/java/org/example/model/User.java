package org.example.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	private Long id;
	private String name;
	private String surname;
	private LocalDate birthDate;
}

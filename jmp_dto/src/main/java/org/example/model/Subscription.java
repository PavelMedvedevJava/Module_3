package org.example.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Subscription {
	private Long id;
	private User user;
	private LocalDate startDate;
}

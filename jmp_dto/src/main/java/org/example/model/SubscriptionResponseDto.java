package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscriptionResponseDto {
	private Long id;
	private Long userId;
	private String startDate;
	private String birthday;
}

package org.example.cloud.converter;

import org.example.model.Subscription;
import org.example.model.SubscriptionRequestDto;
import org.example.model.User;
import java.time.LocalDate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestDtoToSubscriptionConverter implements Converter<SubscriptionRequestDto, Subscription>{
	@Override
	public Subscription convert(SubscriptionRequestDto dto) {
		final User user = User.builder().id(dto.getUserId()).build();

		return Subscription.builder()
			.id(dto.getId())
			.user(user)
			.startDate(LocalDate.now())
			.build();
	}
}

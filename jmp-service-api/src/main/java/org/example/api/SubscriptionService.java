package org.example.api;

import java.util.List;
import org.example.model.SubscriptionRequestDto;
import org.example.model.SubscriptionResponseDto;

public interface SubscriptionService {
	List<SubscriptionResponseDto> getAllSubscriptions();

	SubscriptionResponseDto getSubscription(long id);

	SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionDto);

	SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionDto);

	Boolean deleteSubscription(long id);
}

package org.example.controller;

import java.util.List;
import org.example.model.SubscriptionRequestDto;
import org.example.model.SubscriptionResponseDto;


public interface ServiceController {
	List<SubscriptionResponseDto> getAllSubscriptions();
	SubscriptionResponseDto getSubscription(long userId);
	SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionDto);
	SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionDto);
	Boolean deleteSubscription(long userId);
}

package org.example.cloud.serviceImpl;


import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.example.api.SubscriptionService;
import org.example.cloud.converter.RequestDtoToSubscriptionConverter;
import org.example.cloud.converter.SubscriptionToResponseDtoConverter;
import org.example.cloud.repository.SubscriptionRepository;
import org.example.cloud.repository.UserRepository;
import org.example.model.Subscription;
import org.example.model.SubscriptionRequestDto;
import org.example.model.SubscriptionResponseDto;
import org.example.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
	private SubscriptionRepository subscriptionRepository;
	private UserRepository userRepository;
	private  SubscriptionToResponseDtoConverter toResponseDtoConverter;
	private  RequestDtoToSubscriptionConverter toSubscriptionConverter;


	@Override
	public List<SubscriptionResponseDto> getAllSubscriptions() {
		final List<Subscription> allSubscriptions = subscriptionRepository.getAllSubscriptions();
		return allSubscriptions.stream()
			.map(ss -> toResponseDtoConverter.convert(ss))
			.collect(Collectors.toList());
	}

	@Override
	public SubscriptionResponseDto getSubscription(long subscription_id) {
		final Subscription ss = subscriptionRepository.getSubscription(subscription_id);
		return toResponseDtoConverter.convert(ss);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public SubscriptionResponseDto createSubscription(SubscriptionRequestDto requestDto) {
		Subscription ss = toSubscriptionConverter.convert(requestDto);

		subscriptionRepository.createSubscription(ss);
		final User userFromDb = userRepository.getUserById(ss.getUser().getId());
		ss.setUser(userFromDb);

		return toResponseDtoConverter.convert(ss);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto requestDto) {
		Subscription ss = toSubscriptionConverter.convert(requestDto);

		if (subscriptionRepository.isExistsById(ss.getId())) {
			subscriptionRepository.updateSubscription(ss);
		}else {
			throw new IllegalStateException(String.format("Subscription to update with id = %s is not present in DB", ss.getId()));
		}
		final User userFromDb = userRepository.getUserById(ss.getUser().getId());
		ss.setUser(userFromDb);

		return toResponseDtoConverter.convert(ss);
	}

	@Override
	public Boolean deleteSubscription(long subscription_id) {
		if (subscriptionRepository.isExistsById(subscription_id)) {
			subscriptionRepository.deleteSubscription(subscription_id);
		}else {
			throw new IllegalStateException(String.format("Subscription to update with id = %s is not present in DB", subscription_id));
		}

		return true;
	}
}

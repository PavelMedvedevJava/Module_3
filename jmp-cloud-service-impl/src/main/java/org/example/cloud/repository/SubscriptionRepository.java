package org.example.cloud.repository;

import java.util.List;
import lombok.AllArgsConstructor;
import org.example.cloud.dao.mapper.SubscriptionMapper;
import org.example.model.Subscription;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SubscriptionRepository {
	private final SubscriptionMapper mapper;

	public List<Subscription> getAllSubscriptions(){
		return mapper.getAllSubscriptions();
	}

	public Subscription getSubscription(long id){
		return mapper.getSubscription(id);
	}


	public long createSubscription(Subscription subscription){
		return mapper.createSubscription(subscription);
	}

	public long updateSubscription(Subscription subscription){
		return mapper.updateSubscription(subscription);
	}

	public void deleteSubscription(long id) {
		mapper.deleteSubscription(id);
	}

	public Boolean isExistsById(long id) {
		return mapper.isExistsById(id);
	}
}

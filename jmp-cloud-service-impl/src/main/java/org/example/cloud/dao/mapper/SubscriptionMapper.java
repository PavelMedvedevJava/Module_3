package org.example.cloud.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.model.Subscription;

@Mapper
public interface SubscriptionMapper {
	List<Subscription> getAllSubscriptions();

	Subscription getSubscription(@Param("id") long id);

	long createSubscription(Subscription subscription);

	long updateSubscription(Subscription subscription);

	void deleteSubscription(long id);

	Boolean isExistsById(@Param("id") long id);
}

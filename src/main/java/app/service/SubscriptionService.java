package app.service;

import app.entity.Subscription;

public interface SubscriptionService {

    Subscription setActive(Long id, boolean activeStatus);

}

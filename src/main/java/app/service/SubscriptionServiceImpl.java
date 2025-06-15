package app.service;

import app.entity.Subscription;
import app.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription setActive(Long id, boolean activeStatus) {
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Подписка не найдена")
        );
        subscription.setActive(false);
        return subscriptionRepository.save(subscription);
    }
}

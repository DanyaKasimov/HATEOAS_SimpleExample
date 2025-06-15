package app.repository;

import app.entity.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

  List<Subscription> findByUserId(Long userId);

  @RestResource(path = "by-user-active", rel = "byUserActive")
  Page<Subscription> findByUserIdAndActiveTrue(Long userId, Pageable pageable);
}
package app.controller;

import app.entity.Subscription;
import app.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RepositoryRestController
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PatchMapping("/subscriptions/setActive/{id}/{activeStatus}")
    public ResponseEntity<EntityModel<Subscription>> setActive(@PathVariable Long id, @PathVariable Boolean activeStatus) {
        log.info("Поступил запрос на изменение статуса активности. ID: {}, Status: {}", id, activeStatus);

        return ResponseEntity.ok().body(EntityModel.of(subscriptionService.setActive(id, activeStatus)));
    }
}

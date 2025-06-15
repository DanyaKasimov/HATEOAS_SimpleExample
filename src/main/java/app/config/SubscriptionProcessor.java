package app.config;

import app.controller.SubscriptionController;
import app.entity.Subscription;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class SubscriptionProcessor implements RepresentationModelProcessor<EntityModel<Subscription>> {

    @Override
    public EntityModel<Subscription> process(EntityModel<Subscription> model) {
        Subscription subscription = model.getContent();
        if (subscription != null && !subscription.isActive()) {
            model.add(linkTo(methodOn(SubscriptionController.class)
                    .setActive(subscription.getId(), true)).withRel("activate"));
        }
        return model;
    }
}
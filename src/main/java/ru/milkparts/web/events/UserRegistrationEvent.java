package ru.milkparts.web.events;

import org.springframework.context.ApplicationEvent;
import ru.milkparts.web.models.User;

@SuppressWarnings("serial")
public class UserRegistrationEvent extends ApplicationEvent {
    private final User user;

    public UserRegistrationEvent(User user) {
        super(user);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

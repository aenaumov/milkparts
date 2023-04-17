package ru.milkparts.web.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.milkparts.web.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String  username);
}

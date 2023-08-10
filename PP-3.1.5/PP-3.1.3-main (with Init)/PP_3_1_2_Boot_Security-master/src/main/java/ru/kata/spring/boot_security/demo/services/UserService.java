package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> listUser();

    Optional<User> getUser(long id);

    Optional<User> getUser(String name);

    void saveUser(User user);

    void deleteUser(long id);
}

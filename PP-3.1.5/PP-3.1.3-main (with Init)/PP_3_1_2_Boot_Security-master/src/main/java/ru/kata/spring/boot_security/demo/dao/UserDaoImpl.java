package ru.kata.spring.boot_security.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao, UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format(username)));
        return user;
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUser(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }


    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


}

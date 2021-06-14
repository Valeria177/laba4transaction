package ru.laba.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.laba.training.persist.Model.Role;
import ru.laba.training.persist.Model.User;
import ru.laba.training.persist.UserRepository;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(UserRepr userRepr, Role role) {
        User user = new User();
        user.setUsername(userRepr.getUsername());
        user.setPassword(passwordEncoder.encode(userRepr.getPassword()));
        user.setRole(role);
        userRepository.save(user);
    }
}

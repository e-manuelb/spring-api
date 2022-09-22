package com.api.services;

import com.api.repositories.UserRepository;
import com.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id).get();
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    public User update(User user, Integer id) {
        User existUser = userRepository.findById(id).get();

        if (user.getName() != null) {
            existUser.setName(user.getName());
        }

        if (user.getEmail() != null) {
            existUser.setEmail(user.getEmail());
        }

        if (user.getPassword() != null) {
            existUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }

        user.setUpdatedAt(Instant.now());

        userRepository.save(existUser);

        return existUser;
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}

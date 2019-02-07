package com.epam.external.onlineShop.service.impl;

import com.epam.external.onlineShop.entity.User;
import com.epam.external.onlineShop.repository.UserRepository;
import com.epam.external.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> getUserList() {
        return (List<User>) userRepository.findAll();
    }
}

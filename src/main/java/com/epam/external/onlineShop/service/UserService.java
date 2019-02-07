package com.epam.external.onlineShop.service;

import com.epam.external.onlineShop.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User getUserByLogin(String login);

    List<User> getUserList();
}

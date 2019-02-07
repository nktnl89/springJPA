package com.epam.external.onlineShop.manager;

import com.epam.external.onlineShop.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class UserManager {
    private User user;

    public UserManager() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

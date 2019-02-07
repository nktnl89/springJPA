package com.epam.external.onlineShop.interceptor;

import com.epam.external.onlineShop.entity.User;
import com.epam.external.onlineShop.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private UserManager userManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User currentUser = userManager.getUser();
        if (Objects.isNull(currentUser)) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}

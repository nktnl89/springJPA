package com.epam.external.onlineShop.configuration;

import com.epam.external.onlineShop.interceptor.AuthInterceptor;
import com.epam.external.onlineShop.interceptor.UserNameAwareInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    public AuthInterceptor authInterceptor;

    @Autowired
    public UserNameAwareInterceptor userNameAwareInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/registration", "/logout", "/styles/**", "/scripts/**", "/error");

        registry.addInterceptor(userNameAwareInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/registration", "/logout", "/styles/**", "/scripts/**", "/error");
    }


}

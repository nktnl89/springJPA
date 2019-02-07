package com.epam.external.onlineShop.repository;

import com.epam.external.onlineShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.login = :login")
    User findByLogin(@Param("login") String login);
}

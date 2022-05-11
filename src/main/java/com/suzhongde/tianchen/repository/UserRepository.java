package com.suzhongde.tianchen.repository;

import com.suzhongde.tianchen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, String> {
    User getByUsername(String username);
}
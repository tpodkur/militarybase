package com.tanya.militarybase.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tanya.militarybase.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}

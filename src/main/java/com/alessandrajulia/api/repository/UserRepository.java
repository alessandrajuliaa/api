package com.alessandrajulia.api.repository;

import com.alessandrajulia.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByNameIgnoreCase(String name);
}

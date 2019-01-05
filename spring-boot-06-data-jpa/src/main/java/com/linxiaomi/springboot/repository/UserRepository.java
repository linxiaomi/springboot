package com.linxiaomi.springboot.repository;

import com.linxiaomi.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

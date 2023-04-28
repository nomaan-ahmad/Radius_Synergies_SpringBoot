package com.nomaan.radiusspringboot.repositories;

import com.nomaan.radiusspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

package com.growthprocess.repository;

import com.growthprocess.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}

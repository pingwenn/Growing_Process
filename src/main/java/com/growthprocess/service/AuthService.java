package com.growthprocess.service;

import com.growthprocess.entity.User;
import com.growthprocess.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
	@Autowired
	private UserRepository userRepository;
	
	public boolean login(String email, String password) {
		User user = userRepository.findByEmail(email);
		return user != null && user.getPassword().equals(password);
	}
}

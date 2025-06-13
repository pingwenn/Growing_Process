package com.growthprocess.service;

import com.growthprocess.entity.User;
import com.growthprocess.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
	@Autowired
	private UserRepository userRepository;
	
	
	// 宣告加密工具
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	// 註冊邏輯
	public boolean register(String email, String password, String username) {
		if (userRepository.findByEmail(email) != null) {
			return false;
		}
		
		// 加密密碼
		String encodedPassword = passwordEncoder.encode(password);
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(encodedPassword);
		user.setUsername(username);
		
		userRepository.save(user);
		return true;
	}
	
	// 登入邏輯
	public boolean login(String email, String password) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			return false;
		}
		
		// 驗證密碼是否正確 (比對原始密碼和加密後的密碼)
		return passwordEncoder.matches(password, user.getPassword());
	}
}

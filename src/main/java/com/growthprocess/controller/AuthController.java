package com.growthprocess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.growthprocess.dto.LoginRequest;
import com.growthprocess.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		boolean success = authService.login(request.getEmail(), request.getPassword());
		return success ? "登入成功" : "帳號或密碼錯誤";
	}
}

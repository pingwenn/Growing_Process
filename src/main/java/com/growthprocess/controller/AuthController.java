package com.growthprocess.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.growthprocess.dto.LoginRequest;
import com.growthprocess.dto.RegisterRequest;
import com.growthprocess.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	// 登入API
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		boolean success = authService.login(request.getEmail(), request.getPassword());
		return success ? "登入成功" : "帳號或密碼錯誤";
	}
	
	// 註冊API
	@PostMapping("/register")
	public ResponseEntity<?>  register(@RequestBody @Valid RegisterRequest request, BindingResult result) {
		if (result.hasErrors()) {
			// 回傳第一筆錯誤訊息
			String message = result.getFieldError().getDefaultMessage();
			return ResponseEntity.badRequest().body(Map.of("error", message));
		}
		
		boolean success = authService.register(request.getEmail(), request.getPassword(), request.getUsername());
		
		if (success) {
			return ResponseEntity.ok(Map.of("message", "註冊成功"));
		} else {
			return ResponseEntity.badRequest().body(Map.of("error", "此 Email 已被註冊"));
		}
	}
}

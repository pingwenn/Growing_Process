package com.growthprocess.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
	
	@NotBlank(message = "Email 不可為空")
	@Email(message = "Email 格式錯誤")
	private String email;
	
	@NotBlank(message = "密碼不可為空")
	@Size(min = 6, message = "密碼至少要6個字元")
	private String password;
	
	@NotBlank(message = "名稱不可為空")
	private String username;
	
	// Getter / Setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}

package com.example.security;

public class AuthToken {

	private String token;

	public AuthToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "AuthToken [token=" + token + "]";
	}

}

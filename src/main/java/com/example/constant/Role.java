package com.example.constant;

public class Role {
	
	private Role() {
		throw new IllegalStateException("Constants class.can't instatiate");
	}

	public static final String MANAGER = "hasRole('MANAGER')";
}

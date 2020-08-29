package com.example.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AuthUser extends User {

	private static final long serialVersionUID = 1L;

	private String managerUuid;
	private String firstName;

	public AuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public String getManagerUuid() {
		return managerUuid;
	}

	public void setManagerUuid(String managerUuid) {
		this.managerUuid = managerUuid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}

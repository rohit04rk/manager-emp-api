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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((managerUuid == null) ? 0 : managerUuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthUser other = (AuthUser) obj;
		if (managerUuid == null) {
			if (other.managerUuid != null)
				return false;
		} else if (!managerUuid.equals(other.managerUuid))
			return false;
		return true;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}

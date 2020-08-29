package com.example.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.ManagerDao;
import com.example.entity.Manager;

@Service("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ManagerDao managerDao;

	@Override
	public UserDetails loadUserByUsername(String email) {

		Manager manager = managerDao.findByEmail(email);

		if (manager != null) {
			AuthUser authUser = new AuthUser(manager.getEmail(), manager.getPassword(), getAuthority());
			authUser.setManagerUuid(manager.getManagerUuid());
			authUser.setFirstName(manager.getFirstName());

			return authUser;
		} else {
			throw new UsernameNotFoundException("Bad credentials");
		}

	}

	private List<SimpleGrantedAuthority> getAuthority() {

		return Arrays.asList(new SimpleGrantedAuthority("ROLE_MANAGER"));
	}
}

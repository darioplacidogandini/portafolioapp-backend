package com.dariogandini.portfolio.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("usuario@ejemplo.com".equals(username)) {
			return new User("usuario@ejemplo.com", "$2y$10$LGq.ruEl82fMtFtAnbxfAORb5nsDWRZHJxNGZ4s8x9KlLviiy5PKG",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}

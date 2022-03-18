package com.dariogandini.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class jwtUserDetailsService implements UserDetailsService {

    @Override 
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if ("usuario@prueba.com".equals(email)) {
            return new User("usuario", 
            "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado con el nombre: "
            + email);
        }
    }
}
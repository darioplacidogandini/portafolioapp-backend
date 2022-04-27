package com.dariogandini.portafolioapp.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.dariogandini.portafolioapp.dto.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {
    @PostMapping("iniciar-sesion")
    public User login(@RequestParam("user") String username, @RequestParam("password") String psw) {
        String token = getJWToken(username);
        User user = new User();
        user.setUser(username);
        user.setToken(token);
        return user;
    }

    private String getJWToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.
        commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts.builder().setId("softtekJWT").setSubject(username).
                        claim("authorites", grantedAuthorities.stream().
                        map(GrantedAuthority::getAuthority).collect(Collectors.toList())).
                        setIssuedAt(new Date(System.currentTimeMillis())).
                        setExpiration(new Date(System.currentTimeMillis() + 600000)).
                        signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
        return "Bearer " + token;
    }
}

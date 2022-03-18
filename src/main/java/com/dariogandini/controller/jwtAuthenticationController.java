package com.dariogandini.controller;

import java.util.Objects;

import com.dariogandini.model.jwtRequest;
import com.dariogandini.model.jwtResponse;
import com.dariogandini.config.jwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class jwtAuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired  
    private jwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST) 
        public ResponseEntity<?> generateAuthenticationToken
        (@RequestBody jwtRequest authenticationRequest) throws Exception {

            authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

            final UserDetails userdetails = jwtInMemoryUserDetailsService.
                    loadUserByUsername(authenticationRequest.getEmail());

            final String token = jwtTokenUtil.generateToken(userdetails);

            return ResponseEntity.ok(new jwtResponse(token));
        }

        private void authenticate(String email, String password) throws Exception {
            Objects.requireNonNull(email);
            Objects.requireNonNull(password);
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            } catch (DisabledException e) {
                throw new Exception("Usuario deshabilitado", e);
            } catch (BadCredentialsException e) {
                throw new Exception("CREDENCIALES INVALIDAS", e);
            }
        }
    }


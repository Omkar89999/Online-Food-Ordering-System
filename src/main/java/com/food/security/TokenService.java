//package com.food.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TokenService {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private CustomeUserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtTokenHelper jwtTokenHelper;
//
//    public String authenticateAndGenerateToken(String username, String password) throws AuthenticationException {
//        // Authenticate the user
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//        );
//
//        // If authentication is successful, generate the token
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        return jwtTokenHelper.generateToken(authentication);
//    }
//}

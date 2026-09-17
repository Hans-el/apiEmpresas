package com.manabaware.api.controller;

import com.manabaware.api.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public record LoginRequest(String username, String password) {
    }

    public record LoginResponse(String token) {
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        UserDetails user = org.springframework.security.core.context.SecurityContextHolder
                .getContext().getAuthentication().getPrincipal() instanceof UserDetails ud
                        ? ud
                        : null;

        String token = jwtService.generateToken(
                (UserDetails) authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(request.username(), request.password()))
                        .getPrincipal());

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
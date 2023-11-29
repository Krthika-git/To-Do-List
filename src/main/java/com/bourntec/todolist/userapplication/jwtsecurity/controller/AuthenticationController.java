package com.bourntec.todolist.userapplication.jwtsecurity.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.todolist.userapplication.jwtsecurity.request.AuthenticationRequest;
import com.bourntec.todolist.userapplication.jwtsecurity.request.RegisterRequest;
import com.bourntec.todolist.userapplication.jwtsecurity.response.AuthenticationResponse;
import com.bourntec.todolist.userapplication.jwtsecurity.service.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
		  @Valid @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
		  @Valid  @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
		  @Valid  HttpServletRequest request,
		  @Valid HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }


}

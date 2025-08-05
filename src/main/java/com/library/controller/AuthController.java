package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.Service.AuthenticationService;
import com.library.dtos.LoginRequestDto;
import com.library.dtos.RegisterRequestDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/registernormaluser")
	public ResponseEntity<?>registerNormalUser(@RequestBody RegisterRequestDto req)
	{
		return ResponseEntity.ok(authenticationService.registerNormalUser(req));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?>login(@RequestBody LoginRequestDto req)
	{
		return ResponseEntity.ok(authenticationService.loginUser(req));
	}
}

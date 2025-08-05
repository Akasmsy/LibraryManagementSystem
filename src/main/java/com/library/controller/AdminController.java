package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.Service.AuthenticationService;
import com.library.dtos.RegisterRequestDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('Admin')")
public class AdminController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/registeradminuser")
	public ResponseEntity<?>registerAdminUser(@RequestBody RegisterRequestDto  req)
	{
		return ResponseEntity.ok(authenticationService.registerAdminUser(req));
	}


}

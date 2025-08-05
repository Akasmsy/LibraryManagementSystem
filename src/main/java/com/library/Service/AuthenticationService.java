package com.library.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.dtos.LoginRequestDto;
import com.library.dtos.LoginResponseDto;
import com.library.dtos.RegisterRequestDto;
import com.library.entities.User;
import com.library.repository.UserRepo;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	public User registerNormalUser(RegisterRequestDto req)
	{
		if(userRepo.findByUsername(req.getUsername()).isPresent())
		{
			throw  new RuntimeException("User have already registered");
		}
		
		Set<String>roles=new HashSet<>();
		roles.add("ROLE.USER");
		
		User user = new User();
		user.setUsername(req.getUsername());
		user.setEmail(req.getEmail());
		user.setPassword(passwordEncoder.encode(req.getPassword()));
		user.setRoles(roles);
		
		return userRepo.save(user);
	}
	
	
	
	
	public User registerAdminUser(RegisterRequestDto req)
	{
		if(userRepo.findByUsername(req.getUsername()).isPresent())
		{
			throw  new RuntimeException("User have already registered");
		}
		
		Set<String>roles=new HashSet<>();
		roles.add("ROLE.USER");
		roles.add("ROLE.ADMIN");
		
		User user = new User();
		user.setUsername(req.getUsername());
		user.setEmail(req.getEmail());
		user.setPassword(passwordEncoder.encode(req.getPassword()));
		user.setRoles(roles);
		
		return userRepo.save(user);

	}
	
	
	
	
	public LoginResponseDto login(LoginRequestDto req)
	{
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						
						req.getUsername(),
						req.getPassword()
						)
				
				);
		User user = userRepo.findByUsername(req.getUsername())
				.orElseThrow(()->new RuntimeException("User is Not Register"));
		String token = jwtService.generateToken();
		return LoginResponseDto .builder()
				.username(user.getUsername())
				.token(token)
				.roles(user.getRoles())
				.build();
		
	
	}
}

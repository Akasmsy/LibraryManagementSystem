package com.library.dtos;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {

	private String token;
	private String username;
	private Set<String>roles;
}

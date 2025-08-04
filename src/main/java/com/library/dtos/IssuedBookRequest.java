package com.library.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class IssuedBookRequest {
	
	private LocalDate issueDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	private Boolean isReturned;
	private Long bookId;
	private Long userId;
	
}

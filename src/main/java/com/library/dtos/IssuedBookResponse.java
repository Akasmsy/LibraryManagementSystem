package com.library.dtos;

import java.time.LocalDate;

import com.library.entities.Book;
import com.library.entities.User;

import lombok.Data;
@Data
public class IssuedBookResponse {
	
	
	private LocalDate issueDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	private Boolean isReturned;
	private User user;
	private Book book;

}

package com.library.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class IssuesRecords {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate issueDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	private Boolean isReturned;
	
	@ManyToOne
	@JoinColumn(name="books_id")
	private Book books;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
}

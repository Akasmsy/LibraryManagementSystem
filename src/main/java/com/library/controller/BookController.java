package com.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.Service.BookService;
import com.library.dtos.BookRequestDto;
import com.library.dtos.BookResponseDto;

@RestController
@RequestMapping("/api/Books")
public class BookController {
	
	
	private final BookService bookservice;
	
	public BookController(BookService bookservice)
	{
	    this.bookservice=bookservice;
	}
	
	
	
	
	@GetMapping("/allBook")
	public ResponseEntity<?>listOfBooks()
	{
		return ResponseEntity.ok(bookservice.getAllBooks());
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getBookById(@PathVariable Long id)
	{
		return ResponseEntity.ok(bookservice.getBook(id));
	}
	
	
	@PostMapping("/addBook")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<BookResponseDto>addBook(@RequestBody BookRequestDto book)
	{
		return ResponseEntity.ok(bookservice.createBook(book));
	}
	
	
	@PutMapping("/updateBook/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<BookResponseDto>updateBook(@RequestBody BookRequestDto book,@PathVariable Long id)
	{
		return ResponseEntity.ok(bookservice.updateBook(book, id));
	}
	 
	
	@DeleteMapping("/updateBook/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void>deleteBook(@PathVariable Long id)
	{
		bookservice.delete(id);
	    return ResponseEntity.ok().build();
	}
	

}

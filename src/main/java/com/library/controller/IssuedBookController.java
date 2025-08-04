package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.Service.IssuedBookServiceInterface;

@RestController
@RequestMapping("/IssuedBook")
public class IssuedBookController {
	
	@Autowired
	public IssuedBookServiceInterface issuedBookService;
	
	@PostMapping("/{id}")
	public ResponseEntity<?>createIssuedBookRecords(@PathVariable Long id)
	{
		return ResponseEntity.ok(issuedBookService.createIssueRecords(id));
	}
	
	@PostMapping("/returnBook/{id}")
	public ResponseEntity<?>returnBookRecords(@PathVariable Long id)
	
	{
		
		return ResponseEntity.ok(issuedBookService.returnBooks(id));
	}
}

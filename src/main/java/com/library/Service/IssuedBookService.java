package com.library.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.library.entities.Book;
import com.library.entities.IssuesRecords;
import com.library.entities.User;
import com.library.repository.BookRepo;
import com.library.repository.IssuedBookRepo;
import com.library.repository.UserRepo;

@Service
public class IssuedBookService implements IssuedBookServiceInterface{
	
	@Autowired
	private IssuedBookRepo issueBookRepo;
	
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	

	@Override
	public IssuesRecords createIssueRecords(Long id) {
	
		Book book = bookRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Book Not Found"));
		
		if(!book.getIsAvailable()||book.getQuantity()<=0)
		{
			    throw new RuntimeException("Book is Not Available");
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		
		User user = userRepo.findByName(username)
				.orElseThrow(()->new RuntimeException("User Not Found"));
		
		IssuesRecords issuesRecords = new IssuesRecords();
		issuesRecords.setIssueDate(LocalDate.now());
		issuesRecords.setDueDate(LocalDate.now().plusDays(14));
		issuesRecords.setReturnDate(null);
		issuesRecords.setIsReturned(false);
		issuesRecords.setBooks(book);
		issuesRecords.setUser(user);
		   
		book.setQuantity(book.getQuantity()-1);
		if(book.getQuantity()<=0)
		{
			book.setIsAvailable(false);
		}
		
		bookRepo.save(book);
	return issueBookRepo.save(issuesRecords);
				
		
}



	@Override
	public IssuesRecords returnBooks(Long issuedId) {
		IssuesRecords issuesRecords = issueBookRepo.findById(issuedId)
				.orElseThrow(()->new RuntimeException("Issues Records Not Found"));
		Book book = issuesRecords.getBooks();
		
		issuesRecords.setReturnDate(LocalDate.now());
		issuesRecords.setIsReturned(true);
		book.setQuantity(book.getQuantity()+1);
		book.setIsAvailable(true);
		issuesRecords.setBooks(book);
		bookRepo.save(book);
		return issueBookRepo.save(issuesRecords);
		
		}
	

	
}

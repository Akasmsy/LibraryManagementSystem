package com.library.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dtos.BookRequestDto;
import com.library.dtos.BookResponseDto;
import com.library.dtos.DtoMapper;
import com.library.entities.Book;
import com.library.repository.BookRepo;

@Service
public class BookService implements BookServiceInterface{

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public BookResponseDto createBook(BookRequestDto bookRequestDto) {
		
		Book book = DtoMapper.ReuestToBook(bookRequestDto);
		Book book1 = bookRepo.save(book);
		return DtoMapper.BookToResponse(book1);
	}

	
	@Override
	public List<BookResponseDto> getAllBooks() {
		List<Book>booklist=bookRepo.findAll();
		List<BookResponseDto>bookResponse = new ArrayList<>();
		for(Book books : booklist)
		{
			BookResponseDto bookResponseDto = DtoMapper.BookToResponse(books);
			bookResponse.add(bookResponseDto);
		}
		return bookResponse;
	}

	
	@Override
	public BookResponseDto updateBook(BookRequestDto newbook, Long id) {
		Book existingBook = bookRepo.findById(id).orElseThrow(()-> new RuntimeException("Something Went Wrong"));
		existingBook.setTitle(newbook.getTitle());
		existingBook.setAuthor(newbook.getAuthor());
		existingBook.setISBN(newbook.getISBN());
		existingBook.setQuantity(newbook.getQuantity());
		existingBook.setIsAvailable(newbook.getIsAvailable());
	    
		Book updatedBook = bookRepo.save(existingBook);
		return DtoMapper.BookToResponse(updatedBook);
		
	    
	}

	@Override
	public void delete(Long id) {
	
		bookRepo.deleteById(id);
		
	}

	@Override
	public BookResponseDto getBook(Long id) {
		Book book = bookRepo.findById(id).orElseThrow(()-> new RuntimeException("Something Went Wrong"));
		return DtoMapper.BookToResponse(book);
	}

}

package com.library.Service;

import java.util.List;

import com.library.dtos.BookRequestDto;

import com.library.dtos.BookResponseDto;

public interface BookServiceInterface {

	public BookResponseDto createBook(BookRequestDto bookRequestDto);
	
	public List<BookResponseDto>getAllBooks();
	
	public BookResponseDto updateBook(BookRequestDto book,Long id);
	
	public void  delete(Long id);
	
	public BookResponseDto  getBook(Long id);
	
}

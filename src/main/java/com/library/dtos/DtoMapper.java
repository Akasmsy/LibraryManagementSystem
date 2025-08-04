package com.library.dtos;

import java.time.LocalDateTime;

import com.library.entities.Book;

public class DtoMapper {

	public static Book ReuestToBook(BookRequestDto bookRequestDto)
	{
		Book book = new Book();
		book.setTitle(bookRequestDto.getTitle());
		book.setAuthor(bookRequestDto.getAuthor());
		book.setISBN(bookRequestDto.getISBN());
		book.setQuantity(bookRequestDto.getQuantity());
		book.setIsAvailable(bookRequestDto.getIsAvailable());
		return book;
	}
	
	public static BookResponseDto BookToResponse(Book book)
	{
		BookResponseDto bookResponse = new BookResponseDto();
		bookResponse.setTitle(book.getTitle());
		bookResponse.setAuthor(book.getAuthor());
		bookResponse.setISBN(book.getISBN());
		bookResponse.setQuantity(book.getQuantity());
		bookResponse.setIsAvailable(book.getIsAvailable());
		bookResponse.setCreateDateTime(LocalDateTime.now());
		return bookResponse;
	}
}

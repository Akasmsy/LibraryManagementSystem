package com.library.dtos;

import lombok.Data;

@Data
public class BookRequestDto {

	private String title;
	private String Author;
	private String iSBN;
	private Integer quantity;
    private Boolean isAvailable;
    
}

package com.library.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BookResponseDto {

	private Long id;
	private String title;
	private String Author;
	private String iSBN;
	private Integer quantity;
    private Boolean isAvailable;
    private LocalDateTime createDateTime;
    
}

package com.kh.homework04.book;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookDto {
    private Long no;
    private String title;
    private String author;
    private Long price;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BookDto toDto(BookEntity entity){
        BookDto dto = new BookDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.author = entity.getAuthor();
        dto.price = entity.getPrice();
        dto.delYn = entity.getDelYn();
        dto.createdAt = entity.getCreatedAt();
        dto.updatedAt = entity.getUpdatedAt();
        return dto;
    }
}

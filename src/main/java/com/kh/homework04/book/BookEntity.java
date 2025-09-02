package com.kh.homework04.book;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOOK")
@Getter
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private Long price;
    private String delYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BookEntity() {
        this.delYn = "N";
        this.createdAt = LocalDateTime.now();
    }

    public static BookEntity toEntity(BookDto dto){
        BookEntity entity = new BookEntity();
        entity.title = dto.getTitle();
        entity.author = dto.getAuthor();
        entity.price = dto.getPrice();
        return entity;

    }

    public int update(BookDto dto){
        int result = 0;
        if (dto.getTitle() != null && !dto.getTitle().trim().isEmpty()) {
            this.title = dto.getTitle();
            result = 1;
        }

        if (dto.getAuthor() != null && !dto.getAuthor().trim().isEmpty()) {
            this.author = dto.getAuthor();
            result = 1;
        }

        if (dto.getPrice() != null) {
            this.price = dto.getPrice();
            result = 1;
        }
        this.updatedAt = LocalDateTime.now();
        return result;
    }

    public void delete() {
        this.delYn = "Y";
        this.updatedAt = LocalDateTime.now();
    }
}

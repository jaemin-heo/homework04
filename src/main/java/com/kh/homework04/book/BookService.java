package com.kh.homework04.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;
    public int insert(BookDto dto) {
        BookEntity entity = BookEntity.toEntity(dto);
        return repository.insert(entity);
    }

    public BookDto selectOne(Long no) {
         BookEntity entity = repository.selectOne(no);
         return BookDto.toDto(entity);
    }

    public List<BookDto> selectList() {
        List<BookEntity> entityList = repository.selectList();
        return entityList.stream().map(BookDto::toDto).toList();
    }

    public int update(Long no, BookDto dto) {
        BookEntity entity = repository.selectOne(no);
        return entity.update(dto);
    }

    public int delete(Long no) {
        BookEntity entity = repository.selectOne(no);
        entity.delete();
        return 1;
    }
}

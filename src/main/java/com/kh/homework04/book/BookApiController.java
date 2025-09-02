package com.kh.homework04.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookApiController {
    private final BookService service;

    @PostMapping
    public int insert(@RequestBody BookDto dto){
        return service.insert(dto);
    }

    @GetMapping("{no}")
    public BookDto selectOne(@PathVariable Long no){
        return service.selectOne(no);
    }

    @GetMapping
    public List<BookDto> selectList(){
        return service.selectList();
    }

    @PutMapping("{no}")
    public int update(@PathVariable Long no, @RequestBody BookDto dto){
        return service.update(no,dto);
    }

    @DeleteMapping("{no}")
    public int delete(@PathVariable Long no){
        return service.delete(no);
    }
}

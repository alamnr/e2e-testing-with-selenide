package com.e2e.selenide.e2e_testing_with_selenide;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @GetMapping
    public List<Book> getAllBooks(){
        return List.of(new Book(1L,"42","Effective Java"),
                        new Book(2L,"43","Spring Boot Testing"));
    }
}

package org.oizehsgl.javaLearning.framework.springBoot.openapi.controller;

import org.oizehsgl.javaLearning.framework.springBoot.openapi.mapper.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Collection;

/**
 * book 控制层
 *
 * @author yueyuanzhi
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) {
        // return repository.findById(id).orElseThrow(() -> new BookNotFoundException());
        return null;
    }

    @GetMapping("/")
    public Collection<Book> findBooks() {
        // return repository.getBooks();
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(
            @PathVariable("id") final String id, @RequestBody final Book book) {
        return book;
    }
}
package com.samet.springboot.bookcrud.rest;


import com.samet.springboot.bookcrud.entity.Book;
import com.samet.springboot.bookcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    //create Bookservice instance
    private BookService bookService;

    @Autowired
    public BookRestController(BookService bookService){
        this.bookService=bookService;
    }

    //GET ALL BOOKS
    @GetMapping("/books")
    public List<Book> getAll(){

        return bookService.findAll();
    }


    //Get a book by given ID
    @GetMapping("/books/{bookId}")
    public Book getById(@PathVariable int bookId){
        Book book = bookService.findById(bookId);

        if(book==null){
            throw new RuntimeException("Book Id not found - "+bookId);
        }
        return book;
    }


}

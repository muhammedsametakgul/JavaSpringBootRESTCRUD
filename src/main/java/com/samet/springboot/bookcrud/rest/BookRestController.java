package com.samet.springboot.bookcrud.rest;


import com.samet.springboot.bookcrud.entity.Book;
import com.samet.springboot.bookcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    //Save any book
    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook){
        theBook.setId(0); // if id ==0 , it is save/insert

        Book book = bookService.save(theBook);


        return  book;
    }


    //update existing book
    @PutMapping("/books")
    public Book updateBook(@RequestBody Book theBook){
        Book book= bookService.save(theBook);
        return book;
    }


    //delete the book
    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId){
        Book book = bookService.findById(bookId);

        if(book==null){
            throw new RuntimeException("Id book not found - " +bookId);
        }

        bookService.deleteById(bookId);
        return "Deleted Successfull";
    }
}

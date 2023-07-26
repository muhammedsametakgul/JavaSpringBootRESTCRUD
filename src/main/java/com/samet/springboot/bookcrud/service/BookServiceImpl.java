package com.samet.springboot.bookcrud.service;

import com.samet.springboot.bookcrud.dao.BookDAO;
import com.samet.springboot.bookcrud.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  public class BookServiceImpl implements  BookService{

    private BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO){
        this.bookDAO=bookDAO;
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }
}

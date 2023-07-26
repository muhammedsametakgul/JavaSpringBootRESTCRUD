package com.samet.springboot.bookcrud.service;

import com.samet.springboot.bookcrud.dao.BookDAO;
import com.samet.springboot.bookcrud.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    @Transactional
    public Book save(Book theBook) {
        return bookDAO.save(theBook);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }
}

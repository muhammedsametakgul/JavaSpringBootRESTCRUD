package com.samet.springboot.bookcrud.dao;


import com.samet.springboot.bookcrud.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookDAO {

    List<Book> findAll();

    Book findById(int id);

    Book save(Book theBook);

    void deleteById(int id);
}

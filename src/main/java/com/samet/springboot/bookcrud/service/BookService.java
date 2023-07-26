package com.samet.springboot.bookcrud.service;


import com.samet.springboot.bookcrud.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
}

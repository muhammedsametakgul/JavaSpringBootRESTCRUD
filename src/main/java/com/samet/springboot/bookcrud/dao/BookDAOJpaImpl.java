package com.samet.springboot.bookcrud.dao;

import com.samet.springboot.bookcrud.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOJpaImpl implements BookDAO{

    //define field for entitymanager
    private EntityManager entityManager;


    //set up constructor injection
    @Autowired
    public BookDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }


    @Override
    public List<Book> findAll() {
        //create Query
        TypedQuery<Book> theQuery=entityManager.createQuery("FROM Book",Book.class);

        //get result
        List<Book> books =theQuery.getResultList();

        //return result
        return books;
    }

    @Override
    public Book findById(int id) {
        //find the book by given ID
        Book book = entityManager.find(Book.class,id);
        return book;
    }

    @Override
    public Book save(Book theBook) {

        Book book =entityManager.merge(theBook);

        return book;
    }

    @Override
    public void deleteById(int id) {
        //find the book
        Book  book=entityManager.find(Book.class,id);

        //remove the book
        entityManager.remove(book);
    }
}

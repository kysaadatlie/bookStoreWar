package com.example.bookstorewar.service;

import com.example.bookstorewar.entity.BookEntity;
import com.example.bookstorewar.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public void save(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookEntity getBookById(int id) {
        return bookRepository.findById(id).get();
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}

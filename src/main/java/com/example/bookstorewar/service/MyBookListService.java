package com.example.bookstorewar.service;

import com.example.bookstorewar.entity.MyBookList;
import com.example.bookstorewar.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository myBook;

    public void saveMyBooks(MyBookList book) {
        myBook.save(book);
    }

    public List<MyBookList> getAllMyBooks() {
        return myBook.findAll();
    }

    public void deleteById(int id) {
        myBook.deleteById(id);
    }
}

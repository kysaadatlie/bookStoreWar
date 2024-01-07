package com.example.bookstorewar.controller;

import com.example.bookstorewar.entity.BookEntity;
import com.example.bookstorewar.entity.MyBookList;
import com.example.bookstorewar.service.BookService;
import com.example.bookstorewar.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookListService myBookListService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks() {
        List<BookEntity> list = bookService.getAllBooks();
        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute BookEntity bookEntity) {
        bookService.save(bookEntity);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList> list = myBookListService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        BookEntity bookEntity = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(bookEntity.getId(), bookEntity.getName(), bookEntity.getAuthor(), bookEntity.getPrice());
        myBookListService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        BookEntity bookEntity = bookService.getBookById(id);
        model.addAttribute("bookEntity", bookEntity);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}

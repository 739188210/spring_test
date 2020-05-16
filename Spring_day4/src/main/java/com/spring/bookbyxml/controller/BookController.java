package com.spring.bookbyxml.controller;

import com.spring.bookbyxml.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    public void buyBook() throws Exception {
        bookService.buyBook(1,1);
    }

}

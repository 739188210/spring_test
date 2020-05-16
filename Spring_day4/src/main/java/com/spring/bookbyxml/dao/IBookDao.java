package com.spring.bookbyxml.dao;

import com.spring.bookbyxml.model.Book;

public interface IBookDao {
    Book selectBookNbr(Integer bookid);
    void updateBookNbr(Book book) throws Exception;
    void updateUserBalance(Integer userid, Book book) throws Exception;
}

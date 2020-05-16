package com.spring.book.dao;

import com.spring.book.model.Book;

public interface IBookDao {
    Book selectBookNbr(Integer bookid);
    void updateBookNbr(Book book) throws Exception;
    void updateUserBalance(Integer userid,Book book) throws Exception;
}

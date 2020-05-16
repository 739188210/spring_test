package com.spring.bookbyxml.service;

import com.spring.bookbyxml.dao.IBookDao;
import com.spring.bookbyxml.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookDao bookDao;


    @Override
    public void buyBook(Integer userid, Integer bookid) throws Exception{
        Book book = bookDao.selectBookNbr(bookid);
        bookDao.updateBookNbr(book);
        bookDao.updateUserBalance(userid,book);
    }
}

package com.spring.book.dao;

import com.spring.book.model.Book;
import com.spring.book.model.BookCusotmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao implements IBookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Book selectBookNbr(Integer bookid) {
        String sql = "select * from book where bookid = ?";
        Object[] objs = new Object[]{bookid};
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<>(Book.class);

        Book book = jdbcTemplate.queryForObject(sql,objs,rowMapper);
        return book;
    }

    @Override
    public void updateBookNbr(Book book) throws Exception {
        if(book.getBookstock() > 0){
            Object[] objs = new Object[]{book.getBookid()};
            String sql = "update book set bookstock = bookstock -1 where bookid = ?";
            jdbcTemplate.update(sql,objs);
        }else{
            throw new Exception("该书数量不足");
        }
    }

    @Override
    public void updateUserBalance(Integer userid,Book book) throws Exception {
        String sql = "select * from bookcustomer where userid = ?";
        Object[] objs = new Object[]{userid};
        RowMapper<BookCusotmer> rowMapper = new BeanPropertyRowMapper<>(BookCusotmer.class);

        BookCusotmer bookCusotmer = jdbcTemplate.queryForObject(sql,objs, rowMapper);
        if(bookCusotmer.getUserbalance() < book.getBookprice()){
            throw new Exception("顾客余额不足");
        }else{
            Object[] updateObjs = new Object[]{book.getBookprice(),book.getBookid()};
            String updateSql = "update bookcustomer set userbalance = userbalance - ? where userid = ?";
            jdbcTemplate.update(updateSql,updateObjs);
        }

    }
}

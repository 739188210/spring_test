package com.spring.bookbyxml.model;

import org.springframework.stereotype.Component;

@Component
public class Book {
    private Integer bookid;

    private String bookname;

    private Integer bookstock;

    private Double bookprice;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getBookstock() {
        return bookstock;
    }

    public void setBookstock(Integer bookstock) {
        this.bookstock = bookstock;
    }

    public Double getBookprice() {
        return bookprice;
    }

    public void setBookprice(Double bookprice) {
        this.bookprice = bookprice;
    }
}

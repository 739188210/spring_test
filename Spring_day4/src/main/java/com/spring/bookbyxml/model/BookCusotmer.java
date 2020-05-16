package com.spring.bookbyxml.model;

import org.springframework.stereotype.Component;

@Component
public class BookCusotmer {
    private Integer userid;

    private String username;

    private Double userbalance;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getUserbalance() {
        return userbalance;
    }

    public void setUserbalance(Double userbalance) {
        this.userbalance = userbalance;
    }
}

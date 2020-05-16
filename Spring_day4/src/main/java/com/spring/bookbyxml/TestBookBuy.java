package com.spring.bookbyxml;

import com.spring.bookbyxml.controller.BookController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBookBuy {
    public static void main(String[] args) throws Exception {

        /**
         * 并列关系
         * 即有多个配置文件，需要同时加载这多个配置文件；
         * 可以使用可变参数，
         * 数组
         * String[] configs = {config1,config2};
         * 统配符进行加载；
         * String config = "com/abc/di08/spring-*.xml";
         * ApplicationContext ac = new ClassPathXmlApplicationContext(config);
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("transactionalbyxml/jdbcTemplateByxml.xml");
        BookController bookController = ac.getBean("bookController", BookController.class);
        bookController.buyBook();
    }
}

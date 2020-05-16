package com.spring.book.service;

import com.spring.book.dao.BookDao;
import com.spring.book.dao.IBookDao;
import com.spring.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookDao bookDao;

    /**就近原则
     * @Transactional 可以设置的属性：
     * propagation（事务传播级别（行为））：方法A、B都有事务，当A在调用B时，会将A中的事务传播给B，B对于事务的处理方式就是事务的传播行为。
     *      Propagation.REQUIRED：使用调用者的事务。（默认值）
     *      Propagation.REQUIRES_NEW：将调用者的事务挂起，不使用调用者的事务，而使用自身事务进行处理
     *
     * isolation（事务隔离级别）：针对并发操作的一种规定
     *   1  读未提交：脏读（针对于表中的数据，并发事务修改数据回滚造成的无效读取）
     *   2  读已提交：不可重复读（针对于表中的数据，并发事务修改数据造成的多次读取不一致）
     *   4  可重复读：幻读（针对于表的层次而言，不允许并发事务操作读取的数据，但可操作其余数据）
     *   8  串行化：相当于单线程顺序执行（性能低，消耗大）
     *
     * timeout：在事务强制回滚前最多可以执行（等待）的时间
     *      值是秒数
     *
     * readOnly：指定当前事务中的一系列操作是否为只读。
     *      若设置为只读（true），不管事务中是否有写操作，mysql都会在请求访问数据的时候，不加锁，提高性能
     *      但是如果有些操作的情况，建议一定不能设置只读。
     *
     * rollbackFor||rollbackForClassName||noRollbackFor||noRollbackForClassName
     */
    @Transactional(propagation = Propagation.REQUIRED,timeout = 3)
    @Override
    public void buyBook(Integer userid, Integer bookid) throws Exception {
        Book book = bookDao.selectBookNbr(bookid);
        bookDao.updateBookNbr(book);
        bookDao.updateUserBalance(userid,book);
    }
}

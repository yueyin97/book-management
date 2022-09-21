package com.yy.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Target;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testInsert() {
        Book book = new Book();
        book.setType("Test data...");
        book.setName("Test data...");
        book.setDescription("Test data...");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(1);
        book.setType("Test data 123...");
        book.setName("Test data 123...");
        book.setDescription("Test data 123...");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(2);
    }

    @Test
    void testGetAll() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testPaging() {
        IPage page = new Page(1, 15); // current: current page, size: amount of data shown each page
        bookDao.selectPage(page, null);
    }

    @Test
    void testQuery() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "data"); // select * form tbl_book where name like %Spring%
        bookDao.selectList(queryWrapper);
    }

    @Test
    void testQuery2() {
        String name = "test";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name != null, Book::getName, name);
        bookDao.selectList(lambdaQueryWrapper);
    }

    @Test
    void testQuery3(){ // pagination + query
        String name = "Spring";
        IPage page = new Page(1,10);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(name),Book::getName,"Spring");
        bookDao.selectPage(page, lqw);
    }

}

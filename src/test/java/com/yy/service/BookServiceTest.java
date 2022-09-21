package com.yy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.dao.BookDao;
import com.yy.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void testGetById() {
        bookService.getById(1);
    }

    @Test
    void testInsert() {
        Book book = new Book();
        book.setType("Test data...");
        book.setName("Test data...");
        book.setDescription("Test data...");
        bookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(1);
        book.setType("Test data 123...");
        book.setName("Test data 123...");
        book.setDescription("Test data 123...");
        bookService.update(book);
    }

    @Test
    void testDelete() {
        bookService.delete(2);
    }

    @Test
    void testGetAll() {
        System.out.println(bookService.getAll());
    }

    @Test
    void testPaging() {
        IPage page = bookService.getPage(1, 5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}

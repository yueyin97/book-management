package com.yy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yy.controller.utils.R;
import com.yy.domain.Book;
import com.yy.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        // System.out.println(book);
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        // bug fix: if currentPage > number of pages, then use number of pages as currentPage
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int)page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }
}

package com.yy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.domain.Book;

public interface IBookService extends IService<Book> {
    Boolean delete(Integer id);
    Boolean insert(Book book);
    Boolean modify(Book book);
    Book get(Integer id);
    IPage<Book> getPage(int currentPage, int pageSize);
    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}

package com.gaber.springboottest.controller;

import com.gaber.springboottest.entity.Book;
import com.gaber.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    private BookRepository bookRepository;

    /**
     * 列表接口
     *
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/findAll/{current}/{size}")
    public Page<Book> findAll(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(current - 1, size);
        return bookRepository.findAll(pageable);
    }

    /**
     * 新增接口
     *
     * @param book
     * @return
     */
    @PostMapping("/save")
    public String save(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 详情接口
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public Book findById(@PathVariable("id") Integer id) {
        return bookRepository.findById(id).get();
    }

    /**
     * 修改接口
     *
     * @param book
     * @return
     */
    @PutMapping("/update")
    public String update(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 删除接口
     * @param id
     */
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookRepository.deleteById(id);
    }
}

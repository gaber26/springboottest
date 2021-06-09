package com.gaber.springboottest.repository;

import com.gaber.springboottest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  BookRepository extends JpaRepository<Book, Integer> {
}

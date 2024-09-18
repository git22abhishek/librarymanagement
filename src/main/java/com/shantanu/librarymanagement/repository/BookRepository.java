package com.shantanu.librarymanagement.repository;

import com.shantanu.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String name);
}

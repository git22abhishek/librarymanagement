package com.shantanu.librarymanagement.service;

import com.shantanu.librarymanagement.model.Book;

import java.util.List;

public interface LibraryService {
    Book issueBook(Long id);

    Book returnBook(Long id);

    List<Book> listAllBooks();

    List<Book> searchByName(String name);

 }

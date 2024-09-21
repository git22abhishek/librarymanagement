package com.shantanu.librarymanagement.controller;

import com.shantanu.librarymanagement.model.Book;
import com.shantanu.librarymanagement.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.listAllBooks());
    }

    @PostMapping("/issue/{id}")
    public ResponseEntity<Book> issueBook(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.issueBook(id));
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<Book> returnBook(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.returnBook(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.searchByName(name));
    }

}

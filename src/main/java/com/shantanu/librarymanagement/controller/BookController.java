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
        try {
            Book issuedBook = libraryService.issueBook(id);
            return new ResponseEntity<>(issuedBook, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<Book> returnBook(@PathVariable Long id) {
        try {
            Book returnedBook = libraryService.returnBook(id);
            return new ResponseEntity<>(returnedBook, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.searchByName(name));
    }

}

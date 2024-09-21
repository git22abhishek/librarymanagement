package com.shantanu.librarymanagement.service;

import com.shantanu.librarymanagement.model.Book;
import com.shantanu.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book issueBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent() && !book.get().isIssued()) {
            Book b = book.get();
            b.setIssued(true);
            b.setIssueDate(LocalDate.now());
            b.setDueDate(LocalDate.now().plusDays(15L));
            return bookRepository.save(b);
        }
        throw new RuntimeException("Book is not available");
    }

    @Override
    public Book returnBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent() && book.get().isIssued()) {
            book.get().setIssued(false);
            Book b = book.get();
            b.setIssued(false);
            b.setIssueDate(null);
            b.setDueDate(null);
            return bookRepository.save(b);
        }
        throw new RuntimeException("Book was not issued");
    }

    @Override
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchByName(String name) {
        return bookRepository.findByTitleContainingIgnoreCase(name);
    }
}

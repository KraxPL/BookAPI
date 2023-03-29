package pl.krax.service;

import pl.krax.entity.Book;

import java.util.List;

public interface BookServiceInterface {
    List<Book> findAll();
    void addBook(Book book);
    Book getBookById(Long id);
    void editBook(Long bookId, Book book);
    void deleteBook(Long id);
}

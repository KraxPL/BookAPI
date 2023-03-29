package pl.krax.Service;

import pl.krax.Model.Book;

import java.util.List;

public interface BookServiceInterface {
    List<Book> getBooks();
    void addBook(Book book);
    Book getBookById(Long id);
    void editBook(Long bookId, Book book);
    void deleteBook(Long id);
}

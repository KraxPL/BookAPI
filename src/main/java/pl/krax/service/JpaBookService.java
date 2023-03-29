package pl.krax.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import pl.krax.entity.Book;
import pl.krax.repository.BookRepository;

import java.util.List;

@Primary
@RequiredArgsConstructor
public class JpaBookService implements BookServiceInterface {
    private final BookRepository repository;

    @Override
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @Override
    public void addBook(Book book) {
        repository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void editBook(Long bookId, Book book) {
        repository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        repository.delete(getBookById(id));
    }
}

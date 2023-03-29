package pl.krax.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.krax.entity.Book;
import pl.krax.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class JpaBookService implements BookServiceInterface {

    private final BookRepository repository;

    @Override
    public List<Book> findAll() {
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

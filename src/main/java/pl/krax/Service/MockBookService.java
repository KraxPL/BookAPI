package pl.krax.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.krax.Model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class MockBookService implements BookServiceInterface {
    private List<Book> list;
    private Long id = 0L;

    public MockBookService() {
        list = new ArrayList<>();
        addBook(Book.builder()
                .author("Bruce	Eckel")
                .isbn("9788324631766")
                .title("Thinking	in	Java")
                .publisher("Helion")
                .type("programming")
                .build());

        addBook(Book.builder()
                .author("Sierra	Kathy,	Bates	Bert")
                .isbn("9788324627738")
                .title("Rusz	glowa	Java.")
                .publisher("Helion")
                .type("programming")
                .build());

        addBook(Book.builder()
                .author("Cay	Horstmann,	Gary	Cornell")
                .isbn("9780130819338")
                .title("Java 2 Podstawy")
                .publisher("Helion")
                .type("programming")
                .build());
    }

    private Long next() {
        return id++;
    }

    public void addBook(Book book) {
        Optional.ofNullable(book).ifPresent(n ->
                        list.add(Book.builder()
                                .id(next())
                                .author(n.getAuthor())
                                .isbn(n.getIsbn())
                                .title(n.getTitle())
                                .publisher(n.getPublisher())
                                .type(n.getType())
                                .build()));
        System.out.println("Book added successfully!");
    }

    public List<Book> getBooks() {
        return list;
    }

    public Book getBookById(Long id) {
        return list.stream()
                .filter(n -> id.equals(n.getId()))
                .findAny()
                .orElse(null);
    }

    public void editBook(Long bookId, Book book) {
        Optional.ofNullable(book)
                .filter(n -> bookId > 0)
                .map(n -> getBookById(bookId))
                .map(list::indexOf)
                .ifPresent(n -> list.set(n, book));
        System.out.println("Book successfully edited!");
    }

    public void deleteBook(Long id) {
        Optional.ofNullable(getBookById(id))
                .ifPresent(list::remove);
        System.out.println("Book successfully deleted!");
    }
}

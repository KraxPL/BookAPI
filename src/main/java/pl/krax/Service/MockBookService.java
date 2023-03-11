package pl.krax.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.krax.Model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class MockBookService {
    private final List<Book> list;
    private static Long nextId = 4L;
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public void addBookToList(Book book) {
        book.setId(nextId);
        this.list.add(book);
        nextId++;
        System.out.println("Book added successfully!");
    }

    public List<Book> getBooks() {
        return this.list;
    }

    public Book getBookById(long id) {
        for (Book book : list) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void editBook(Book book) {
        Book b = list.get(Math.toIntExact(book.getId()));
        if (b != null) {
            b.setIsbn(book.getIsbn());
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
            b.setPublisher(book.getPublisher());
            b.setType(book.getType());
        }
        System.out.println("Book successfully edited!");
    }

    public void deleteBook(Long id) {
        list.remove(this.getBookById(id));
        System.out.println("Book successfully deleted!");
    }
}

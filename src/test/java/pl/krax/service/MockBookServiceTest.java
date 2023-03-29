package pl.krax.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.krax.entity.Book;

class MockBookServiceTest {
    private MockBookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new MockBookService();
    }

    @Test
    void shouldGetBookFromRepository() {
        //given
        Long bookId = 2L;
        List<Object> expectingValues = Arrays.asList(bookId, "Java 2 Podstawy", "9780130819338", "Cay Horstmann, Gary Cornell",
                "Helion", "programming");
        //when
        Book book = bookService.getBookById(bookId);

        //then
        assertThat(book).extracting("id", "title", "isbn", "author", "publisher", "type")
                .isEqualTo(expectingValues);
    }

    @Test
    void shouldGetNullWhenBookDontExist() {
        //expected
        assertThat(bookService.getBookById(10L)).isNull();
    }

    @Test
    void shouldCreateAndAddANewBook() {
        //given
        Book book = Book.builder()
                .id(4L)
                .type("poradnik")
                .author("Jan Kowal")
                .isbn("979797121212")
                .publisher("Nowy świat")
                .title("Poradnik jak podbić świat")
                .build();

        //when
        bookService.addBook(book);

        //then
        assertThat(bookService.findAll().size()).isEqualTo(4);
    }

    @Test
    void shouldNotCreateAndAddANewBookWhenObjectIsNull() {
        //given
        //when
        bookService.addBook(null);

        //then
        assertThat(bookService.findAll().size()).isEqualTo(3);
    }

    @Test
    void shouldDeleteBookFromRepository() {
        //given
        Long bookId = 1L;
        //when
        bookService.deleteBook(bookId);

        //then
        assertThat(bookService.findAll().size()).isEqualTo(2);
        assertThat(bookService.getBookById(bookId)).isNull();
    }

    @Test
    void shouldUpdateBook(){
        //given
        Long bookId = 2L;
        Book book = Book.builder()
                .id(bookId)
                .author("Ezekiel")
                .isbn("666")
                .title("Hell Bible")
                .publisher("Devil Himself")
                .type("horror")
                .build();

        //when
        bookService.editBook(bookId, book);

        //then
        assertThat(bookService.getBookById(bookId)).isEqualTo(book);
    }
}
package pl.krax.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.krax.Model.Book;
import pl.krax.Service.MockBookService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping("/books")
public class BookController {
@Autowired
private MockBookService mockBookService;
    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
    @GetMapping("/")
    public List<Book> getAllBooks(){
        return mockBookService.getBooks();
    }
    @PostMapping("/")
    public void addBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String author,
                          @RequestParam String publisher, @RequestParam String bookTopic, HttpServletResponse response) throws IOException {
        mockBookService.addBookToList(new Book(isbn, title, author, publisher, bookTopic));
        response.sendRedirect("/books/");
    }
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public Book getBookById(@PathVariable long id){
        return mockBookService.getBookById(id);
    }
}

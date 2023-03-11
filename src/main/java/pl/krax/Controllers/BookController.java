package pl.krax.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.krax.Model.Book;
import pl.krax.Service.MockBookService;

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
    public void addBook(@RequestBody Book book) {
        mockBookService.addBookToList(book);
    }
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public Book getBookById(@PathVariable Long id){
        return mockBookService.getBookById(id);
    }
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public void editBook(@RequestBody Book book){
        mockBookService.editBook(book);
    }
    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        mockBookService.deleteBook(id);
    }
}

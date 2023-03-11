package pl.krax.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krax.Configuration.Model.Book;
import pl.krax.MockBookService;

@Controller
@RestController
@RequestMapping("/books")
public class BookController {

private MockBookService mockBookService;
    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

}

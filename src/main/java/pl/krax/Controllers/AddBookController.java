package pl.krax.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.krax.Service.MockBookService;
@Controller
public class AddBookController {
    @Autowired
    private MockBookService mockBookService;
    @RequestMapping("/addBook")
    public String addBookForm(){
        return "createNewBook";
    }
}

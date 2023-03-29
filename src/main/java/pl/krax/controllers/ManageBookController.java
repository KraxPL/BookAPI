package pl.krax.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.krax.entity.Book;
import pl.krax.service.BookServiceInterface;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class ManageBookController {

    private final BookServiceInterface bookService;

    @GetMapping("/all")
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "/book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        return "/book/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult result){
        if (result.hasErrors()){
            return "/book/add";
        }
        bookService.addBook(book);
        return "redirect:/admin/books/all";
    }
    @GetMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
        return "redirect:/admin/books/all";
    }
    @GetMapping("/show/{bookId}")
    public String showBookInfo(@PathVariable Long bookId, Model model){
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        return "/book/show";
    }
    @GetMapping("/edit/{bookId}")
    public String editBookForm(@PathVariable Long bookId, Model model){
        model.addAttribute("book", bookService.getBookById(bookId));
        return "/book/edit";
    }
    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId, @Valid Book book, BindingResult result){
        if (result.hasErrors()){
            return "/book/edit";
        }
        bookService.editBook(bookId, book);
        return "redirect:/admin/books/all";
    }
}


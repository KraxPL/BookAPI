package pl.krax.Configuration.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Getter
@Setter
public class Book {
    private long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String bookTopic;

}

package pl.krax.Model;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    private long id;
    @NonNull
    private String isbn;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private String publisher;
    @NonNull
    private String bookTopic;

}

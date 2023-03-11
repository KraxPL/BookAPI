package pl.krax.Model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;
    @NonNull
    private String isbn;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private String publisher;
    @NonNull
    private String type;

}

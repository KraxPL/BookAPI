package pl.krax.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Builder
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


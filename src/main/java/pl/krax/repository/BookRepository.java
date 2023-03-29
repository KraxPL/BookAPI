package pl.krax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krax.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}

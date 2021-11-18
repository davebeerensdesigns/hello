package nl.novi.hello.repository;

import nl.novi.hello.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Iterable<Book> findAllByTitle(String title);
    Iterable<Book> findAllByTitleContainingIgnoreCase(String title);

    @Query("SELECT b FROM Book b WHERE b.title LIKE CONCAT('%',:s,'%')")
    Iterable<Book> searchByTitleLike(@Param("s") String s);
}

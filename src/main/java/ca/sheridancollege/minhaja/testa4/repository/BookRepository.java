package ca.sheridancollege.minhaja.testa4.repository;

import ca.sheridancollege.minhaja.testa4.beans.book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<book, Long> {
    List<book> findByTitle(String title);
}

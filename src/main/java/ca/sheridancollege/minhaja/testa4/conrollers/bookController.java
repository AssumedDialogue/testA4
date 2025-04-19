package ca.sheridancollege.minhaja.testa4.conrollers;

import ca.sheridancollege.minhaja.testa4.beans.book;
import ca.sheridancollege.minhaja.testa4.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/books")
public class bookController {
    private static final Logger log = LoggerFactory.getLogger(bookController.class);
    private BookRepository bookRepository;

    public bookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    public book postBook(@RequestBody book book) {
        return bookRepository.save(book);
    }

    @PutMapping(consumes = "application/json")
    public Long putBookCollection(@RequestBody List<book> bookList) {
        bookRepository.saveAll(bookList);
        return bookRepository.count();
    }

    @PutMapping("/{id}")
    public Long putIndividualBook(@RequestBody book book,@PathVariable Long id) {
        book.setId(id);
        bookRepository.save(book);
        log.info("Book" + book);
        return bookRepository.count();
    }

    @DeleteMapping("/{id}")
    public Long deleteIndividualBook(@PathVariable Long id) {
        log.info("delete","delete book " + id);
        bookRepository.deleteById(id);
        return bookRepository.count();
    }

    @DeleteMapping
    public Long deleteAllBooks() {
        bookRepository.deleteAll();
        return bookRepository.count();
    }




}

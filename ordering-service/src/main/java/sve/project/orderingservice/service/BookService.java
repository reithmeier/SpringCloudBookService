package sve.project.orderingservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.orderingservice.domain.Book;
import sve.project.orderingservice.repos.BookRepository;

import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }

    @Transactional
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    @Transactional
    public Book saveBook(Book Book){
        return bookRepository.save(Book);
    }

    @Transactional
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}

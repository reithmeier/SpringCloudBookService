package sve.project.analyticsservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.analyticsservice.domain.Book;
import sve.project.analyticsservice.exception.NotFoundException;
import sve.project.analyticsservice.repos.BookRepository;

import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()) {
            throw new NotFoundException(id, Book.class.getSimpleName());
        }
        return book.get();
    }

    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book saveBook(Long id, Integer ratingSum, Integer ratingCount, Integer bookSum) {
        Book book = new Book(id, ratingSum, ratingCount, bookSum);
        bookRepository.save(book);
        return book;
    }

    @Transactional
    public Book deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
            return book.get();
        }
        throw new NotFoundException(id, Book.class.getSimpleName());
    }
}

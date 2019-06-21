package sve.project.bookservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.bookservice.domain.Author;
import sve.project.bookservice.domain.Book;
import sve.project.bookservice.domain.Publisher;
import sve.project.bookservice.messaging.Sender;
import sve.project.bookservice.repos.AuthorRepository;
import sve.project.bookservice.repos.BookRepository;
import sve.project.bookservice.repos.PublisherRepository;

import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    private final Sender sender;

    public BookService(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository, Sender sender) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.sender = sender;
    }

    @Transactional
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()) {
            throw new RuntimeException("Not found");
        }
        return book.get();
    }

    @Transactional
    public Book saveBook(Book book) {
        bookRepository.save(book);
        sender.sendCreateBook(book);
        return book;
    }

    @Transactional
    public Book saveBook(String name, Long authorId, Long publisherId) {
        Optional<Author> author = authorRepository.findById(authorId);
        Optional<Publisher> publisher = publisherRepository.findById(publisherId);
        /*
        Iterable<Author> authors = authorRepository.findAll();
        System.out.println("all authors");
        authors.forEach(System.out::println);
        Iterable<Publisher> publishers = publisherRepository.findAll();
        System.out.println("all publishers");
        authors.forEach(System.out::println);
        */
        if (!(author.isPresent() && publisher.isPresent())) {
            throw new RuntimeException("Not found");
        }

        Book book = new Book(name, author.get(), publisher.get());
        bookRepository.save(book);

        sender.sendCreateBook(book);

        return book;
    }

    @Transactional
    public Book deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
            sender.sendDeleteBook(book.get());
            return book.get();
        }
        throw new RuntimeException("Not found");
    }
}

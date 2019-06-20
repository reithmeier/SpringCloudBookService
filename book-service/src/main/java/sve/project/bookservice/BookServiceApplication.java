package sve.project.bookservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sve.project.bookservice.domain.Author;
import sve.project.bookservice.domain.Book;
import sve.project.bookservice.domain.Publisher;
import sve.project.bookservice.service.AuthorService;
import sve.project.bookservice.service.BookService;
import sve.project.bookservice.service.PublisherService;

import java.util.Optional;

@SpringBootApplication
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner init(BookService bookService, AuthorService authorService, PublisherService publisherService) {

        return args -> {
/*
            Author a1 = new Author("Fritz", "Fritzberger");
            Author a2 = new Author("Peter", "Peterson");
            authorService.saveAuthor(a1);
            authorService.saveAuthor(a2);


            Publisher p1 = new Publisher("Hüpfer Verlag");
            Publisher p2 = new Publisher("Springer Verlag");
            publisherService.savePublisher(p1);
            publisherService.savePublisher(p2);


            Book book1 = new Book("n3", a1, p1);
            Book book2 = new Book("n2", a1, p2);
            Book book3 = new Book("n1", a2, p1);
            Book book4 = new Book("n2", a2, p2);
            bookService.saveBook(book1);
            bookService.saveBook(book2);
            bookService.saveBook(book3);
            bookService.saveBook(book4);
*/
            System.out.println("Book id=5");
            Optional<Book> obj = bookService.getBookById(5L);
            obj.ifPresent(System.out::println);

            System.out.println("AllBooks");
            Iterable<Book> books = bookService.getBooks();
            books.forEach(System.out::println);

        };

    }

}

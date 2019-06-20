package sve.project.bookservice.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import sve.project.bookservice.domain.Author;
import sve.project.bookservice.domain.Book;
import sve.project.bookservice.domain.Publisher;
import sve.project.bookservice.repos.AuthorRepository;
import sve.project.bookservice.repos.BookRepository;
import sve.project.bookservice.repos.PublisherRepository;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final BookRepository bookRepo;

    private final AuthorRepository authorRepo;

    private final PublisherRepository publisherRepo;

    public Mutation(BookRepository bookRepo, AuthorRepository authorRepo, PublisherRepository publisherRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.publisherRepo = publisherRepo;
    }


    //deleteBook(id:ID): Book
    public Book deleteBook(Long id){
        Optional<Book> book = bookRepo.findById(id);
        if(book.isPresent()) {
            bookRepo.delete(book.get());
            return book.get();
        }
        throw new RuntimeException("Not found");
    }


    //saveBook(name:String, authorId: ID, publisherId:ID) : Book
    public Book saveBook(String name, Long authorId, Long publisherId){
        Optional<Author> author = authorRepo.findById(authorId);
        Optional<Publisher> publisher = publisherRepo.findById(publisherId);
        Book book = new Book(name, author.get(), publisher.get());
        bookRepo.save(book);
        return book;
    }
}

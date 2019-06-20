package sve.project.bookservice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import sve.project.bookservice.domain.Author;
import sve.project.bookservice.domain.Book;
import sve.project.bookservice.domain.Publisher;
import sve.project.bookservice.repos.BookRepository;

@Component
public class Query implements GraphQLQueryResolver {
    private final BookRepository repository;

    public Query(BookRepository repository) {
        this.repository = repository;
    }

    //allBooks : [Book]
    public Iterable<Book> allBooks(){
        return repository.findAll();
    }

    //book(id:ID!) : Book
    public Book book(Long id){
        return repository.findById(id).get();
    }

}


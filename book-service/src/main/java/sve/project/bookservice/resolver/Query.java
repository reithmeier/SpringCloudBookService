package sve.project.bookservice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import sve.project.bookservice.domain.Book;
import sve.project.bookservice.service.BookService;

@Component
public class Query implements GraphQLQueryResolver {
    private final BookService repository;

    public Query(BookService repository) {
        this.repository = repository;
    }

    //allBooks : [Book]
    public Iterable<Book> allBooks(){
        return repository.getBooks();
    }

    //book(id:ID!) : Book
    public Book book(Long id){
        return repository.getBookById(id);
    }

}


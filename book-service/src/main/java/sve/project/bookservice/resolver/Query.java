package sve.project.bookservice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import sve.project.bookservice.domain.Book;
import sve.project.bookservice.service.BookService;

@Component
public class Query implements GraphQLQueryResolver {
    private final BookService service;

    public Query(BookService service) {
        this.service = service;
    }

    //allBooks : [Book]
    public Iterable<Book> allBooks(){
        return service.getBooks();
    }

    //book(id:ID!) : Book
    public Book book(Long id){
        return service.getBookById(id);
    }

}


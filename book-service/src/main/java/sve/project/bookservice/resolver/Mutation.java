package sve.project.bookservice.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import sve.project.bookservice.domain.Book;
import sve.project.bookservice.service.BookService;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final BookService bookService;

    public Mutation(BookService bookService) {
        this.bookService = bookService;
    }


    //deleteBook(id:ID): Book
    public Book deleteBook(Long id) {
        return bookService.deleteBook(id);
    }


    //saveBook(name:String, authorId: ID, publisherId:ID) : Book
    public Book saveBook(String name, Long authorId, Long publisherId) {
        return bookService.saveBook(name, authorId, publisherId);
    }
}

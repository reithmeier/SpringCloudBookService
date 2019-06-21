package sve.project.orderingservice.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import sve.project.orderingservice.domain.Book;
import sve.project.orderingservice.messaging.events.BookEvent;
import sve.project.orderingservice.service.BookService;

@EnableBinding(Sink.class)
public class Receiver {

    private final BookService bookService;

    public Receiver(BookService bookService) {
        this.bookService = bookService;
    }

    @StreamListener(Sink.INPUT)
    public void receiveBook(BookEvent event) {
        Book book = event.toBook();
        bookService.saveBook(book);
    }
}

package sve.project.bookservice.messaging;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import sve.project.bookservice.domain.Book;
import sve.project.bookservice.messaging.events.BookEvent;

@EnableBinding(EventSource.class)
public class Sender {

    private final EventSource eventSource;

    public Sender(EventSource eventSource) {
        this.eventSource = eventSource;
    }

    public BookEvent sendCreateBook(Book book) {
        BookEvent bookEvent = new BookEvent(book, BookEvent.Action.CREATE);
        eventSource.bookEvent().send(MessageBuilder.withPayload(bookEvent).build());
        return bookEvent;
    }

    public BookEvent sendDeleteBook(Book book) {
        BookEvent bookEvent = new BookEvent(book, BookEvent.Action.DELETE);
        eventSource.bookEvent().send(MessageBuilder.withPayload(bookEvent).build());
        return bookEvent;
    }
}

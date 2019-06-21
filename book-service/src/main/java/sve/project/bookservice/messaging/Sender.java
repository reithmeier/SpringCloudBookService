package sve.project.bookservice.messaging;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import sve.project.bookservice.domain.Book;
import sve.project.bookservice.messaging.events.BookEvent;

@EnableBinding(BookEventSource.class)
public class Sender {

    private final BookEventSource bookEventSource;

    public Sender(BookEventSource bookEventSource) {
        this.bookEventSource = bookEventSource;
    }

    public BookEvent sendCreateBook(Book book) {
        BookEvent bookEvent = new BookEvent(book, BookEvent.Action.CREATE);
        bookEventSource.bookEvent().send(MessageBuilder.withPayload(bookEvent).build());
        bookEventSource.bookRating().send(MessageBuilder.withPayload(bookEvent).build());
        return bookEvent;
    }

    public BookEvent sendDeleteBook(Book book) {
        BookEvent bookEvent = new BookEvent(book, BookEvent.Action.DELETE);
        bookEventSource.bookEvent().send(MessageBuilder.withPayload(bookEvent).build());
        bookEventSource.bookRating().send(MessageBuilder.withPayload(bookEvent).build());
        return bookEvent;
    }
}

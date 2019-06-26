package sve.project.orderingservice.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import sve.project.orderingservice.domain.Book;
import sve.project.orderingservice.domain.User;
import sve.project.orderingservice.messaging.events.BookEvent;
import sve.project.orderingservice.messaging.events.UserEvent;
import sve.project.orderingservice.service.BookService;
import sve.project.orderingservice.service.UserService;

@EnableBinding(EventSink.class)
public class Receiver {


    private final BookService bookService;
    private final UserService userService;

    public Receiver(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @StreamListener(value = "bookChannel")
    public void receiveBook(BookEvent event) {
        Book book = event.toBook();
        bookService.saveBook(book);
        System.out.println("received: " + book);
    }


    @StreamListener(value = "userChannel")
    public void receiveUser(UserEvent event) {
        User user = event.toUser();
        userService.saveUser(user);
        System.out.println("received: " + user);
    }
}

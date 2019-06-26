package sve.project.ratingservice.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import sve.project.ratingservice.domain.Book;
import sve.project.ratingservice.domain.User;
import sve.project.ratingservice.messaging.events.BookEvent;
import sve.project.ratingservice.messaging.events.UserEvent;
import sve.project.ratingservice.service.BookService;
import sve.project.ratingservice.service.UserService;

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

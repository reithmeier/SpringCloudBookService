package sve.project.analyticsservice.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import sve.project.analyticsservice.domain.Book;
import sve.project.analyticsservice.domain.OrderEntry;
import sve.project.analyticsservice.domain.User;
import sve.project.analyticsservice.messaging.events.Action;
import sve.project.analyticsservice.messaging.events.OrderEvent;
import sve.project.analyticsservice.messaging.events.RatingEvent;
import sve.project.analyticsservice.service.BookService;
import sve.project.analyticsservice.service.OrderService;
import sve.project.analyticsservice.service.UserService;

@EnableBinding(EventSink.class)
public class Receiver {

    private final BookService bookService;
    private final UserService userService;
    private final OrderService orderService;

    public Receiver(BookService bookService, UserService userService, OrderService orderService) {
        this.bookService = bookService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @StreamListener(value = "orderChannel")
    public void receiveOrder(OrderEvent event) {
        OrderEntry orderEntry = event.toOrderEntry();
        Book book = null;
        User user = null;
        try {
            book = bookService.getBookById(orderEntry.getBook());
        } catch (RuntimeException ignored) {
        }
        try {
            user = userService.getUserById(orderEntry.getUser());
        } catch (RuntimeException ignored) {
        }

        if (book == null) {
            book = new Book(orderEntry.getBook(), 0, 0, 0);
        }

        if (user == null) {
            user = new User(orderEntry.getUser(), 0, 0, 0);
        }

        if (event.getAction() == Action.CREATE) {
            book.setOrderSum(book.getOrderSum() + 1);
            user.setOrderSum(user.getOrderSum() + 1);
            orderService.saveOrder(orderEntry);
        } else if (event.getAction() == Action.DELETE) {
            book.setOrderSum(book.getOrderSum() - 1);
            user.setOrderSum(user.getOrderSum() - 1);
            orderService.deleteOrder(orderEntry.getId());
        }

        bookService.saveBook(book);
        userService.saveUser(user);

        System.out.println("received: " + event);
    }


    @StreamListener(value = "ratingChannel")
    public void receiveRating(RatingEvent event) {
        Book book = null;
        User user = null;
        try {
            book = bookService.getBookById(event.getBook());
        } catch (RuntimeException ignored) {
        }
        try {
            user = userService.getUserById(event.getUser());
        } catch (RuntimeException ignored) {
        }

        if (book == null) {
            book = new Book(event.getBook(), 0, 0, 0);
        }

        if (user == null) {
            user = new User(event.getUser(), 0, 0, 0);
        }

        if (event.getAction() == Action.CREATE) {
            book.setRatingCount(book.getRatingCount() + 1);
            book.setRatingSum(book.getRatingSum() + event.getValue());
            user.setRatingCount(book.getRatingCount() + 1);
            user.setRatingSum(book.getRatingSum() + event.getValue());
        } else if (event.getAction() == Action.DELETE) {
            book.setRatingCount(book.getRatingCount() - 1);
            book.setRatingSum(book.getRatingSum() - event.getValue());
            user.setRatingCount(book.getRatingCount() - 1);
            user.setRatingSum(book.getRatingSum() - event.getValue());
        }

        bookService.saveBook(book);
        userService.saveUser(user);

        System.out.println("received: " + event);
    }
}

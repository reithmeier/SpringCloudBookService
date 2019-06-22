package sve.project.analyticsservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import sve.project.analyticsservice.domain.Book;
import sve.project.analyticsservice.domain.OrderEntry;
import sve.project.analyticsservice.domain.User;
import sve.project.analyticsservice.service.BookService;
import sve.project.analyticsservice.service.OrderService;
import sve.project.analyticsservice.service.UserService;

@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class AnalyticsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnalyticsServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(
            BookService bookService,
            OrderService orderService,
            UserService userService) {

        return args -> {
            /*
            Book book1 = new Book(5L, 1, 1, 1);
            Book book2 = new Book(6L, 8, 1, 1);
            Book book3 = new Book(7L, 0, 0, 0);
            Book book4 = new Book(8L, 0, 0, 0);
            bookService.saveBook(book1);
            bookService.saveBook(book2);
            bookService.saveBook(book3);
            bookService.saveBook(book4);

            OrderEntry orderEntry1 = new OrderEntry(1L, 5L, 11L, "2019-04-03");
            OrderEntry orderEntry2 = new OrderEntry(2L, 6L, 11L, "2019-04-04");
            orderService.saveOrder(orderEntry1);
            orderService.saveOrder(orderEntry2);

            User user1 = new User(1L, 9, 2, 1);
            User user2 = new User(2L, 0, 0, 1);
            userService.saveUser(user1);
            userService.saveUser(user2);
            */
            System.out.println("All Orders");
            Iterable<OrderEntry> all = orderService.getOrders();
            all.forEach(System.out::println);

            System.out.println("All Books");
            Iterable<Book> all1 = bookService.getBooks();
            all1.forEach(System.out::println);

            System.out.println("All Users");
            Iterable<User> all2 = userService.getUsers();
            all2.forEach(System.out::println);

        };
    }
}

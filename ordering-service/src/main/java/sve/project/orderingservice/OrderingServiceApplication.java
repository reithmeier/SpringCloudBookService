package sve.project.orderingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sve.project.orderingservice.domain.Book;
import sve.project.orderingservice.domain.OrderEntry;
import sve.project.orderingservice.domain.User;
import sve.project.orderingservice.service.BookService;
import sve.project.orderingservice.service.OrderService;
import sve.project.orderingservice.service.UserService;

@SpringBootApplication
public class OrderingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner init(BookService bookService, OrderService orderService, UserService userService) {

        return args -> {

/*
            Book book1 = new Book(5L, "n3", false);
            Book book2 = new Book(6L, "n2", false);
            Book book3 = new Book(7L, "n1", false);
            Book book4 = new Book(8L, "n2", false);
            bookService.saveBook(book1);
            bookService.saveBook(book2);
            bookService.saveBook(book3);
            bookService.saveBook(book4);

            User user1 = new User(11L, "userName1", false);
            User user2 = new User(12L, "userName2", true);
            userService.saveUser(user1);
            userService.saveUser(user2);

            OrderEntry orderEntry1 = new OrderEntry("2019-04-03", book1, user1);
            OrderEntry orderEntry2 = new OrderEntry("2019-04-04", book2, user1);
            orderService.saveOrder(orderEntry1);
            orderService.saveOrder(orderEntry2);
*/


            System.out.println("All Orders");
            Iterable<OrderEntry> all = orderService.getOrders();
            all.forEach(System.out::println);

        };

    }

}

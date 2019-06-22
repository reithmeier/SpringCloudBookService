package sve.project.ratingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import sve.project.ratingservice.domain.Book;
import sve.project.ratingservice.domain.Rating;
import sve.project.ratingservice.domain.User;
import sve.project.ratingservice.service.BookService;
import sve.project.ratingservice.service.RatingService;
import sve.project.ratingservice.service.UserService;

@EnableDiscoveryClient
@SpringBootApplication
public class RatingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner init(BookService bookService, RatingService ratingService, UserService userService) {

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

            Rating rating1 = new Rating(1, book1, user1);
            Rating rating2 = new Rating(8, book2, user1);
            ratingService.saveRating(rating1);
            ratingService.saveRating(rating2);
*/


            System.out.println("All Ratings");
            Iterable<Rating> all = ratingService.getRatings();
            all.forEach(System.out::println);

        };

    }
    
}

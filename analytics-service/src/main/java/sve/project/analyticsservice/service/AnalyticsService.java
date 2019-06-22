package sve.project.analyticsservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.analyticsservice.domain.*;
import sve.project.analyticsservice.repos.OrderEntryRepository;
import sve.project.analyticsservice.repos.UserRepository;
import sve.project.analyticsservice.repos.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AnalyticsService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final OrderEntryRepository orderEntryRepository;

    public AnalyticsService(UserRepository userRepository, BookRepository bookRepository, OrderEntryRepository orderEntryRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.orderEntryRepository = orderEntryRepository;
    }

    //calc orderByRating: [OrderByRating]
    @Transactional
    public List<OrderByRating> orderByRating() {
        List<OrderByRating> result = new ArrayList<>();

        List<Book> books = bookRepository.findAll();
        for (Book book : books){
            int rating = Math.round((float)book.getRatingSum() / (float)book.getRatingCount());
            OrderByRating orderByRating = find(result, rating);
            if (orderByRating == null){
                orderByRating = new OrderByRating(rating, 0);
                result.add(orderByRating);
            }
            orderByRating.setOrders(orderByRating.getOrders() + book.getOrderSum());
        }

        return result;
    }

    private OrderByRating find(List<OrderByRating> ratings, int rating) {
        for (OrderByRating orderByRating : ratings){
            if (orderByRating.getRating() == rating) {
                return orderByRating;
            }
        }
        return null;
    }

    //calc avgOrderPerUser: Float
    @Transactional
    public Float avgOrderPerUser(){
        List<User> users = userRepository.findAll();
        float sum = 0;

        for (User user : users){
            sum += user.getOrderSum();
        }

        return sum / users.size();
    }



    //ordersPerDay: [OrdersPerDay]
    @Transactional
    public List<OrdersPerDay> ordersPerDay(){
        List<OrdersPerDay> result = new ArrayList<>();
        List<OrderEntry> orderEntries = orderEntryRepository.findAll();

        for (OrderEntry order : orderEntries){
            String date = order.getDate();
            OrdersPerDay ordersPerDay = find(result, date);
            if (ordersPerDay == null){
                ordersPerDay = new OrdersPerDay(0, date);
                result.add(ordersPerDay);
            }
            ordersPerDay.setOrders(ordersPerDay.getOrders() + 1);
        }

        return result;
    }

    private OrdersPerDay find(List<OrdersPerDay> ordersByDay, String date) {
        for (OrdersPerDay ordersPerDay : ordersByDay){
            if (ordersPerDay.getDay().equals(date)) {
                return ordersPerDay;
            }
        }
        return null;
    }

}

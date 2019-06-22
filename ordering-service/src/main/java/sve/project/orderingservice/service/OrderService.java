package sve.project.orderingservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.orderingservice.domain.Book;
import sve.project.orderingservice.domain.OrderEntry;
import sve.project.orderingservice.domain.User;
import sve.project.orderingservice.messaging.Sender;
import sve.project.orderingservice.repos.BookRepository;
import sve.project.orderingservice.repos.OrderRepository;
import sve.project.orderingservice.repos.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final Sender sender;


    public OrderService(OrderRepository orderRepository, BookRepository bookRepository, UserRepository userRepository, Sender sender) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.sender = sender;
    }

    @Transactional
    public Iterable<OrderEntry> getOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public OrderEntry getOrderById(Long id) {
        Optional<OrderEntry> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            throw new RuntimeException("Not found");
        }
        return order.get();
    }

    @Transactional
    public OrderEntry saveOrder(OrderEntry orderEntry) {
        OrderEntry order = orderRepository.save(orderEntry);
        sender.sendCreateOrder(order);
        return order;
    }

    @Transactional
    public OrderEntry saveOrder(String date, Long userId, Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        Optional<User> user = userRepository.findById(userId);

        if (!(book.isPresent() && user.isPresent())
                || book.get().getDeleted()
                || user.get().getDeleted()) {
            throw new RuntimeException("Not found");
        }

        OrderEntry orderEntry = new OrderEntry(date, book.get(), user.get());
        orderRepository.save(orderEntry);
        sender.sendCreateOrder(orderEntry);
        return orderEntry;
    }

    @Transactional
    public OrderEntry deleteOrder(Long id) {
        Optional<OrderEntry> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.delete(order.get());
            sender.sendDeleteOrder(order.get());
            return order.get();
        }
        throw new RuntimeException("Not found");
    }
}

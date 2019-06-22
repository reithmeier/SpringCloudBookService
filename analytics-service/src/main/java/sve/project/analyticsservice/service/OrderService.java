package sve.project.analyticsservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.analyticsservice.domain.OrderEntry;
import sve.project.analyticsservice.repos.OrderEntryRepository;

import java.util.Optional;

@Service
@Transactional
public class OrderService {
    private final OrderEntryRepository orderEntryRepository;


    public OrderService(OrderEntryRepository orderEntryRepository) {
        this.orderEntryRepository = orderEntryRepository;
    }

    @Transactional
    public Iterable<OrderEntry> getOrders() {
        return orderEntryRepository.findAll();
    }

    @Transactional
    public OrderEntry getOrderById(Long id) {
        Optional<OrderEntry> order = orderEntryRepository.findById(id);
        if (!order.isPresent()) {
            throw new RuntimeException("Not found");
        }
        return order.get();
    }

    @Transactional
    public OrderEntry saveOrder(OrderEntry orderEntry) {
        return orderEntryRepository.save(orderEntry);
    }

    @Transactional
    public OrderEntry saveOrder(Long id, String date, Long book, Long user) {
        OrderEntry orderEntry = new OrderEntry(id, book, user, date);
        orderEntryRepository.save(orderEntry);
        return orderEntry;
    }

    @Transactional
    public OrderEntry deleteOrder(Long id) {
        Optional<OrderEntry> order = orderEntryRepository.findById(id);
        if (order.isPresent()) {
            orderEntryRepository.delete(order.get());
            return order.get();
        }
        throw new RuntimeException("Not found");
    }
}

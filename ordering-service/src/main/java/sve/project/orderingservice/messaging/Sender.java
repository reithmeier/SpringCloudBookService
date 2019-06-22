package sve.project.orderingservice.messaging;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import sve.project.orderingservice.domain.OrderEntry;
import sve.project.orderingservice.messaging.events.OrderEvent;

@EnableBinding(EventSource.class)
public class Sender {

    private final EventSource eventSource;

    public Sender(EventSource eventSource) {
        this.eventSource = eventSource;
    }

    public OrderEvent sendCreateOrder(OrderEntry order) {
        OrderEvent orderEvent = new OrderEvent(order, OrderEvent.Action.CREATE);
        eventSource.orderEvent().send(MessageBuilder.withPayload(orderEvent).build());
        return orderEvent;
    }

    public OrderEvent sendDeleteOrder(OrderEntry order) {
        OrderEvent orderEvent = new OrderEvent(order, OrderEvent.Action.DELETE);
        eventSource.orderEvent().send(MessageBuilder.withPayload(orderEvent).build());
        return orderEvent;
    }
}

package sve.project.orderingservice.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrderEventSink {
    @Input("bookChannel")
    SubscribableChannel bookEvent();

    @Input("userChannel")
    SubscribableChannel userEvent();

}

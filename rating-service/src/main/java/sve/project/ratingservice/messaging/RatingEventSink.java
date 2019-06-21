package sve.project.ratingservice.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RatingEventSink {
    @Input("bookRatingChannel")
    SubscribableChannel bookEvent();

    @Input("userRatingChannel")
    SubscribableChannel userEvent();

}

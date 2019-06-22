package sve.project.ratingservice.messaging;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import sve.project.ratingservice.domain.Rating;
import sve.project.ratingservice.messaging.events.RatingEvent;

@EnableBinding(EventSource.class)
public class Sender {

    private final EventSource eventSource;

    public Sender(EventSource eventSource) {
        this.eventSource = eventSource;
    }

    public RatingEvent sendCreateRating(Rating rating) {
        RatingEvent ratingEvent = new RatingEvent(rating, RatingEvent.Action.CREATE);
        eventSource.ratingEvent().send(MessageBuilder.withPayload(ratingEvent).build());
        return ratingEvent;
    }

    public RatingEvent sendDeleteRating(Rating rating) {
        RatingEvent ratingEvent = new RatingEvent(rating, RatingEvent.Action.DELETE);
        eventSource.ratingEvent().send(MessageBuilder.withPayload(ratingEvent).build());
        return ratingEvent;
    }
}

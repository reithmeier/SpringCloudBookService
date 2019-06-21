package sve.project.bookservice.messaging;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BookEventSource {
    @Output("bookChannel")
    MessageChannel bookEvent();

    @Output("bookRatingChannel")
    MessageChannel bookRating();
}

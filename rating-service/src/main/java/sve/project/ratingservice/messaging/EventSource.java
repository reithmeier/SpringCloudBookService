package sve.project.ratingservice.messaging;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventSource {
    @Output("ratingChannel")
    MessageChannel ratingEvent();
}

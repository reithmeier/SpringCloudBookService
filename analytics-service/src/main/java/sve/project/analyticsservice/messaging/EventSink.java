package sve.project.analyticsservice.messaging;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventSink {
    @Input("orderChannel")
    MessageChannel orderEvent();

    @Input("ratingChannel")
    MessageChannel ratingEvent();
}

package sve.project.accountservice.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventSource {
    @Output("userChannel")
    MessageChannel userEvent();
}

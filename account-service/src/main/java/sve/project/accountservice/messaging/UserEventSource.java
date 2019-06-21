package sve.project.accountservice.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserEventSource {
    @Output("userChannel")
    MessageChannel userEvent();
}

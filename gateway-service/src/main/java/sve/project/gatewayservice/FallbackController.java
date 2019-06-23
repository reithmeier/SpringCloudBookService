package sve.project.gatewayservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "service unavailable")
    @RequestMapping("/hystrixfallback")
    public String hystrixfallback() {
        //throw new ServiceUnavailableException("account-service unavailable");
        return "service unavailable";
    }

}
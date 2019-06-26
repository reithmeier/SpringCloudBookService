package sve.project.gatewayservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * only to test if hystrix works
 *
 */
@RestController
public class TestController {
    @RequestMapping("/test/hystrix")
    public void test(){
        throw new RuntimeException("test");
    }
}

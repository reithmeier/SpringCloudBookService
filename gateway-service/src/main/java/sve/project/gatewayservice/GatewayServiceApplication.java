package sve.project.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }




    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //account
                .route("account-graphql", r -> r
                        .path("/account/graphql")
                        .filters(f -> f
                                .rewritePath("^/account", "")
                                .hystrix(c -> c
                                        .setName("fallbackCmd")
                                        .setFallbackUri("forward:/hystrixfallback")))
                        .uri("lb://SVE.PROJECT.ACCOUNTSERVICE/graphql"))

                //analytics
                .route("analytics-graphql", r -> r
                        .path("/analytics/graphql")
                        .filters(f -> f
                                .rewritePath("^/analytics", "")
                                .hystrix(c -> c
                                        .setName("fallbackCmd")
                                        .setFallbackUri("forward:/hystrixfallback")))
                        .uri("lb://SVE.PROJECT.ANALYTICSSERVICE/graphql"))

                //book
                .route("book-graphql", r -> r
                        .path("/book/graphql")
                        .filters(f -> f
                                .rewritePath("^/book", "")
                                .hystrix(c -> c
                                        .setName("fallbackCmd")
                                        .setFallbackUri("forward:/hystrixfallback")))
                        .uri("lb://SVE.PROJECT.BOOKSERVICE/graphql"))

                //order
                .route("order-graphql", r -> r
                        .path("/order/graphql")
                        .filters(f -> f
                                .rewritePath("^/order", "")
                                .hystrix(c -> c
                                        .setName("fallbackCmd")
                                        .setFallbackUri("forward:/hystrixfallback")))
                        .uri("lb://SVE.PROJECT.ORDERSERVICE/graphql"))

                //rating
                .route("rating-graphql", r -> r
                        .path("/rating/graphql")
                        .filters(f -> f
                                .rewritePath("^/rating", "")
                                .hystrix(c -> c
                                        .setName("fallbackCmd")
                                        .setFallbackUri("forward:/hystrixfallback")))
                        .uri("lb://SVE.PROJECT.RATINGSERVICE/graphql"))

                //test hystrix
                .route("test-hystrix", r -> r
                .path("/hystrix")
                .filters(f -> f
                        .hystrix(c -> c
                                .setName("fallbackCmd")
                                .setFallbackUri("forward:/hystrixfallback")))
                .uri("lb://SVE.PROJECT.GATEWAYSERVICE/test"))
                .build();
    }

}

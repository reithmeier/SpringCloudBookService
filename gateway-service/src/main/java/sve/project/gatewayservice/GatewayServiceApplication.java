package sve.project.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

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
                        .filters(f->f.rewritePath("^/account", ""))
                        .uri("lb://SVE.PROJECT.ACCOUNTSERVICE/graphql"))

                //analytics
                .route("analytics-graphql", r -> r
                        .path("/analytics/graphql")
                        .filters(f->f.rewritePath("^/analytics", ""))
                        .uri("lb://SVE.PROJECT.ANALYTICSSERVICE/graphql"))

                //book
                .route("book-graphql", r -> r
                        .path("/book/graphql")
                        .filters(f->f.rewritePath("^/book", ""))
                        .uri("lb://SVE.PROJECT.BOOKSERVICE/graphql"))

                //order
                .route("order-graphql", r -> r
                        .path("/order/graphql")
                        .filters(f->f.rewritePath("^/order", ""))
                        .uri("lb://SVE.PROJECT.ORDERSERVICE/graphql"))

                //rating
                .route("rating-graphql", r -> r
                        .path("/rating/graphql")
                        .filters(f->f.rewritePath("^/rating", ""))
                        .uri("lb://SVE.PROJECT.RATINGSERVICE/graphql"))
                .build();
    }

}

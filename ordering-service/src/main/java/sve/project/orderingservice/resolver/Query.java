package sve.project.orderingservice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import sve.project.orderingservice.domain.OrderEntry;
import sve.project.orderingservice.service.OrderService;

@Component
public class Query implements GraphQLQueryResolver {
    private final OrderService service;

    public Query(OrderService service) {
        this.service = service;
    }

    //allOrders : [OrderEntry]
    public Iterable<OrderEntry> allOrders(){
        return service.getOrders();
    }

    //orderEntry(id:ID!) : OrderEntry
    public OrderEntry orderEntry(Long id){
        return service.getOrderById(id);
    }

}


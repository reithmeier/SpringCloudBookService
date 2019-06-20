package sve.project.orderingservice.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import sve.project.orderingservice.domain.OrderEntry;
import sve.project.orderingservice.service.OrderService;

@Component
public class Mutation implements GraphQLMutationResolver {


    private final OrderService orderService;


    public Mutation(OrderService orderService) {
        this.orderService = orderService;
    }


    //cancleOrder(id:ID): OrderEntry
    public OrderEntry cancleOrder(Long id){
        return orderService.deleteOrder(id);
    }


    //addOrder(date:String, userId:ID!, bookId:ID!) : OrderEntry
    public OrderEntry addOrder(String date, Long userId, Long bookId){
        return orderService.saveOrder(date, userId, bookId);

    }
}

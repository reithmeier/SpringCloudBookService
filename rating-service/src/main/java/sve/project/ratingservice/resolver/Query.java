package sve.project.ratingservice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import sve.project.ratingservice.domain.Rating;
import sve.project.ratingservice.service.RatingService;

@Component
public class Query implements GraphQLQueryResolver {
    private final RatingService service;

    public Query(RatingService service) {
        this.service = service;
    }

    //allRatings : [Rating]
    public Iterable<Rating> allRatings(){
        return service.getRatings();
    }

    //rating(id:ID!) : Rating
    public Rating rating(Long id){
        return service.getRatingById(id);
    }

}


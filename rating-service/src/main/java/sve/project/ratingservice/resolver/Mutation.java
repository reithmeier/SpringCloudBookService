package sve.project.ratingservice.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import sve.project.ratingservice.domain.Rating;
import sve.project.ratingservice.service.RatingService;

@Component
public class Mutation implements GraphQLMutationResolver {


    private final RatingService ratingService;


    public Mutation(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    //removeRating(id:ID): Rating
    public Rating removeRating(Long id){
        return ratingService.deleteRating(id);
    }


    //addRating(value:Int, userId:ID!, bookId:ID!) : Rating
    public Rating addRating(Integer value, Long userId, Long bookId){
        return ratingService.saveRating(value, userId, bookId);

    }
}

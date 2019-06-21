package sve.project.ratingservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.ratingservice.domain.Book;
import sve.project.ratingservice.domain.Rating;
import sve.project.ratingservice.domain.User;
import sve.project.ratingservice.repos.BookRepository;
import sve.project.ratingservice.repos.RatingRepository;
import sve.project.ratingservice.repos.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class RatingService {
    private final RatingRepository ratingRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;


    public RatingService(RatingRepository ratingRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Iterable<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Transactional
    public Rating getRatingById(Long id) {
        Optional<Rating> rating = ratingRepository.findById(id);
        if (!rating.isPresent()) {
            throw new RuntimeException("Not found");
        }
        return rating.get();
    }

    @Transactional
    public Rating saveRating(Rating ratingEntry) {
        return ratingRepository.save(ratingEntry);
    }

    @Transactional
    public Rating saveRating(Integer value, Long userId, Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        Optional<User> user = userRepository.findById(userId);

        if (!(book.isPresent() && user.isPresent())
                || book.get().getDeleted()
                || user.get().getDeleted()) {
            throw new RuntimeException("Not found");
        }

        Rating ratingEntry = new Rating(value, book.get(), user.get());
        ratingRepository.save(ratingEntry);
        return ratingEntry;
    }

    @Transactional
    public Rating deleteRating(Long id) {
        Optional<Rating> rating = ratingRepository.findById(id);
        if (rating.isPresent()) {
            ratingRepository.delete(rating.get());
            return rating.get();
        }
        throw new RuntimeException("Not found");
    }
}

package sve.project.analyticsservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.analyticsservice.domain.OrderEntry;
import sve.project.analyticsservice.domain.User;
import sve.project.analyticsservice.exception.NotFoundException;
import sve.project.analyticsservice.repos.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new NotFoundException(id, User.class.getSimpleName());
        }
        return user.get();
    }

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User saveUser(Long id, Integer ratingSum, Integer ratingCount, Integer userSum) {
        User user = new User(id, ratingSum, ratingCount, userSum);
        userRepository.save(user);
        return user;
    }

    @Transactional
    public User deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return user.get();
        }
        throw new NotFoundException(id, User.class.getSimpleName());
    }
}

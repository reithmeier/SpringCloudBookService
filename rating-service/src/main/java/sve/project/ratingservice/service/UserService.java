package sve.project.ratingservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.ratingservice.domain.User;
import sve.project.ratingservice.repos.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    @Transactional
    public User saveUser(User User){
        return userRepository.save(User);
    }

    @Transactional
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}

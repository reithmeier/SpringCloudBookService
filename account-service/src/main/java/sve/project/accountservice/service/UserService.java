package sve.project.accountservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.accountservice.domain.User;
import sve.project.accountservice.messaging.Sender;
import sve.project.accountservice.repos.UserRepository;
import sve.project.accountservice.repos.AddressRepository;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final Sender sender;

    public UserService(UserRepository userRepository, AddressRepository addressRepository, Sender sender) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.sender = sender;
    }

    @Transactional
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new RuntimeException("Not found");
        }
        return user.get();
    }

    @Transactional
    public User saveUser(User user) {
        userRepository.save(user);
        sender.sendCreateUser(user);
        return user;
    }

    @Transactional
    public User saveUser(String name, String firstName, String lastName) {
        User user = new User(name, firstName, lastName);
        userRepository.save(user);
        sender.sendCreateUser(user);
        return user;
    }

    @Transactional
    public User deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            sender.sendDeleteUser(user.get());
            return user.get();
        }
        throw new RuntimeException("Not found");
    }
}

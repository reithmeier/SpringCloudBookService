package sve.project.accountservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sve.project.accountservice.domain.Address;
import sve.project.accountservice.domain.User;
import sve.project.accountservice.exception.NotFoundException;
import sve.project.accountservice.repos.AddressRepository;
import sve.project.accountservice.repos.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressService(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Iterable<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Transactional
    public Address getAddressById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if (!address.isPresent()) {
            throw new NotFoundException(id, Address.class.getSimpleName());
        }
        return address.get();
    }

    @Transactional
    public Address saveAddress(Address address) {
        addressRepository.save(address);
        return address;
    }

    @Transactional
    public Address saveAddress(String country, String zipCode, String town, String street, String house) {
        Address address = new Address(country, zipCode, town, street, house);
        addressRepository.save(address);
        return address;
    }

    @Transactional
    public Address deleteAddress(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
            return address.get();
        }
        throw new NotFoundException(id, Address.class.getSimpleName());
    }

    @Transactional
    public Address addAddressToUser(Long userId, Address address) {
        Optional<User> userOpt = userRepository.findById(userId);
        if(!userOpt.isPresent()){
            throw new NotFoundException(userId, User.class.getSimpleName());
        }
        User user = userOpt.get();

        address.setUser(user);
        addressRepository.save(address);

        user.getAddresses().add(address);
        userRepository.save(user);
        return address;
    }
}

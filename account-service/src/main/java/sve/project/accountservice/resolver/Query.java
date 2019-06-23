package sve.project.accountservice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import sve.project.accountservice.domain.Address;
import sve.project.accountservice.domain.User;
import sve.project.accountservice.service.AddressService;
import sve.project.accountservice.service.UserService;

@Component
public class Query implements GraphQLQueryResolver {
    private final UserService userService;
    private final AddressService addressService;

    public Query(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    //    allUsers: [User]
    public Iterable<User> allUsers() {
        return userService.getUsers();
    }

    //    allAddresses: [Address]
    public Iterable<Address> allAddresses() {
        return addressService.getAddresses();
    }

    //    user(id:ID!): User
    public User user(Long id) {
        return userService.getUserById(id);
    }

    //    address(id:ID!): Address
    public Address address(Long id) {
        return addressService.getAddressById(id);
    }


    public Boolean hystrixDebug() throws Exception {
        throw new Exception("hystrix debug");
    }
}


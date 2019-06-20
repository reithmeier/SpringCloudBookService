package sve.project.accountservice.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import sve.project.accountservice.domain.Address;
import sve.project.accountservice.domain.AddressInput;
import sve.project.accountservice.domain.User;
import sve.project.accountservice.service.AddressService;
import sve.project.accountservice.service.UserService;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final UserService userService;
    private final AddressService addressService;

    public Mutation(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    //    addUser(name: String, firsName: String, lastName:String) : User
    public User addUser(String name, String firstName, String lastName){
        return userService.saveUser(name, firstName, lastName);
    }

    //    addAddressToUser(userId:ID, address:Address): Address
    public Address addAddressToUser(Long userId, AddressInput address){
        return addressService.addAddressToUser(userId, new Address(address));
    }
}

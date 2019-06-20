package sve.project.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import sve.project.accountservice.domain.Address;
import sve.project.accountservice.domain.User;
import sve.project.accountservice.service.AddressService;
import sve.project.accountservice.service.UserService;

@EnableDiscoveryClient
@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner init(AddressService addressService, UserService userService) {

        return args -> {
/*
            Address address1 = new Address("austria", "4664", "Steyermühl", "Hauptstraße", "1");
            Address address2 = new Address("germany", "12345", "Deutschstadt", "Hauptstraße", "1");
            Address address3 = new Address("germany", "12345", "Deutschstadt", "Hauptstraße", "1");

            User user1 = new User("userName1", "Fritz", "Fritzhuber");
            User user2 = new User( "userName2", "Karl", "Karlsberger");
            userService.saveUser(user1);
            userService.saveUser(user2);

            addressService.addAddressToUser(user1.getId(), address1);
            addressService.addAddressToUser(user1.getId(), address2);
            addressService.addAddressToUser(user2.getId(), address3);
*/


            System.out.println("All ");
            Iterable<Address> all = addressService.getAddresses();
            all.forEach(System.out::println);
            System.out.println("All ");
            Iterable<User> all2 = userService.getUsers();
            all2.forEach(System.out::println);

        };

    }

}

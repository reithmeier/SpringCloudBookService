package sve.project.accountservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.accountservice.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}

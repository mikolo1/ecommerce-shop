package mikolo.ecommerceshop.repositories;

import mikolo.ecommerceshop.entity.Address;
import mikolo.ecommerceshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository <Address, Long> {

    public Address findAddressByUser(User user);
}

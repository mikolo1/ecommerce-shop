package mikolo.ecommerceshop.services;

import lombok.RequiredArgsConstructor;
import mikolo.ecommerceshop.dto.AddressDto;
import mikolo.ecommerceshop.entity.Address;
import mikolo.ecommerceshop.repositories.AddressRepository;
import mikolo.ecommerceshop.utils.MainUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final MainUtils mainUtils;
    private final AddressRepository addressRepository;

    public Address create(AddressDto addressDto) {
        Address address = mainUtils.addressDtoToAddressEntityConverter(addressDto);
        return addressRepository.save(address);
    }
}

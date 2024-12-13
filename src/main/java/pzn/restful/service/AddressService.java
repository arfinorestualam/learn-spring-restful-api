package pzn.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pzn.restful.entity.Address;
import pzn.restful.entity.Contact;
import pzn.restful.entity.User;
import pzn.restful.model.AddressResponse;
import pzn.restful.model.CreateAddressRequest;
import pzn.restful.repository.AddressRepository;
import pzn.restful.repository.ContactRepository;

import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ValidationService validationService;

    //create
    @Transactional
    public AddressResponse create(User user, CreateAddressRequest request) {
        validationService.validate(request);

        //search user
        Contact contact = contactRepository.findFirstByUserAndId(user, request.getContactId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));

        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setContact(contact);
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setProvince(request.getProvince());
        address.setCountry(request.getCountry());
        address.setPostalCode(request.getPostalCode());
        
        addressRepository.save(address);
        
        return toAddressResponse(address);
    }

    private AddressResponse toAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .province(address.getProvince())
                .country(address.getCountry())
                .postalCode(address.getPostalCode())
                .build();
    }
}

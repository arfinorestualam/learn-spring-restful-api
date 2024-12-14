package pzn.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pzn.restful.entity.User;
import pzn.restful.model.AddressResponse;
import pzn.restful.model.CreateAddressRequest;
import pzn.restful.model.WebResponse;
import pzn.restful.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(
            path = "/api/contacts/{contactId}/addresses",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> create(User user,
                                               @RequestBody CreateAddressRequest request,
                                               @PathVariable("contactId") String contactId) {
        request.setContactId(contactId);
        AddressResponse response = addressService.create(user, request);
        return WebResponse.<AddressResponse>builder()
                .data(response)
                .build();
    }

    @GetMapping(
            path = "/api/contacts/{contactId}/addresses/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> get(User user,
                                            @PathVariable("contactId") String contactId,
                                            @PathVariable("addressId") String addressId) {
        AddressResponse response = addressService.get(user, contactId, addressId);
        return WebResponse.<AddressResponse>builder().data(response).build();
    }
}

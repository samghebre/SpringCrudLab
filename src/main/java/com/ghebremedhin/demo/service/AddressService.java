package com.ghebremedhin.demo.service;

import com.ghebremedhin.demo.model.Address;

import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    Address updateAddress(Address address);

    List<Address> getAllAddress();

    Address getAddressById(long id);

    void deleteAddress(long id);
}

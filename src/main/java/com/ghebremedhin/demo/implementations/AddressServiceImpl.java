package com.ghebremedhin.demo.implementations;

import com.ghebremedhin.demo.exceptions.ResourceNotFoundException;
import com.ghebremedhin.demo.model.Address;
import com.ghebremedhin.demo.repositories.AddressRepository;
import com.ghebremedhin.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        Optional<Address> addressDb = this.addressRepository.findById(address.getId());
        if(addressDb.isPresent()){
            Address address1 = addressDb.get();
            address1.setId(address.getId());
            address1.setNumber(address.getNumber());
            address1.setStreet(address.getStreet());
            address1.setState(address.getState());
            addressRepository.save(address1);
            return address1;
        }else{
            throw new ResourceNotFoundException("Record not found with id : " + address.getId());
        }
    }

    @Override
    public List<Address> getAllAddress() {
        return this.addressRepository.findAll();
    }

    @Override
    public Address getAddressById(long addressId) {
        Optional<Address> addressDb = this.addressRepository.findById(addressId);

        if(addressDb.isPresent()){
            return addressDb.get();
        }else{
            throw new ResourceNotFoundException("Record not found with id : " + addressId);
        }
    }

    @Override
    public void deleteAddress(long addressId) {
        Optional<Address> addressDb = this.addressRepository.findById(addressId);

        if(addressDb.isPresent()){
            this.addressRepository.delete(addressDb.get());
        }else{
            throw new ResourceNotFoundException("record not found with id : " + addressId);
        }

    }
}

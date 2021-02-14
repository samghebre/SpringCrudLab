package com.ghebremedhin.demo.controllers;

import com.ghebremedhin.demo.model.Address;
import com.ghebremedhin.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getAllAddress(){
        return ResponseEntity.ok().body(addressService.getAllAddress());
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address>getAddressById(@PathVariable long id){
        return ResponseEntity.ok().body(this.addressService.getAddressById(id));
    }

    @PostMapping("/addresses")
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        return ResponseEntity.ok().body(this.addressService.createAddress(address));
    }

    @PutMapping("/addresses/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable long id, @RequestBody Address address){
        address.setId(id);
        return ResponseEntity.ok().body(this.addressService.updateAddress(address));
    }

    @DeleteMapping("/addresses/{id}")
    public HttpStatus deleteAddress(@PathVariable long id){
        this.addressService.deleteAddress(id);
        return HttpStatus.OK;
    }

}

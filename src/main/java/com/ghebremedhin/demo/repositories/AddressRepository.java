package com.ghebremedhin.demo.repositories;

import com.ghebremedhin.demo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

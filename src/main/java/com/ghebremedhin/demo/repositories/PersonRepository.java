package com.ghebremedhin.demo.repositories;

import com.ghebremedhin.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

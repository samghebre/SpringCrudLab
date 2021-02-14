package com.ghebremedhin.demo.implementations;

import com.ghebremedhin.demo.exceptions.ResourceNotFoundException;
import com.ghebremedhin.demo.model.Person;
import com.ghebremedhin.demo.repositories.PersonRepository;
import com.ghebremedhin.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        Optional<Person> personDb = this.personRepository.findById(person.getId());
        if(personDb.isPresent()){
            Person person1 = personDb.get();
            person1.setId(person.getId());
            person1.setName(person.getName());
            person1.setAge(person.getAge());
            person1.setBio(person.getBio());
            personRepository.save(person1);
            return person1;
        }else{
            throw new ResourceNotFoundException("Record not found with id" + person.getId());
        }
    }

    @Override
    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }

    @Override
    public Person getPersonById(long personId) {
        Optional<Person> personDb = this.personRepository.findById(personId);

        if(personDb.isPresent()){
            return personDb.get();
        }else{
            throw new ResourceNotFoundException("Record not found with id :" + personId);
        }
    }

    @Override
    public void deletePerson(long personId) {
        Optional<Person> personDb = this.personRepository.findById(personId);

        if(personDb.isPresent()){
            this.personRepository.delete(personDb.get());
        }else{
            throw new ResourceNotFoundException("Record not found with id :" + personId);
        }

    }
}

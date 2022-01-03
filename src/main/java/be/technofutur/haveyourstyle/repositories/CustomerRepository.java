package be.technofutur.haveyourstyle.repositories;

import org.springframework.stereotype.Repository;

import be.technofutur.haveyourstyle.models.entities.Customer;

@Repository
public interface CustomerRepository extends UserRepository<Customer>{
   
}

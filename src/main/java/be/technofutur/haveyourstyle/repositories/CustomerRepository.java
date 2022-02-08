package be.technofutur.haveyourstyle.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import be.technofutur.haveyourstyle.models.entities.Customer;

@Repository
public interface CustomerRepository extends UserRepository<Customer>{
    Optional<Customer> findByEmail(String email);
}

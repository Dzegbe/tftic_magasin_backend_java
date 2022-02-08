package be.technofutur.haveyourstyle.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.technofutur.haveyourstyle.models.entities.Customer;
import be.technofutur.haveyourstyle.models.entities.CustomerMeasurements;

@Repository
public interface CustomerMeasurementRepository extends JpaRepository<CustomerMeasurements,Long>{
   
    
}

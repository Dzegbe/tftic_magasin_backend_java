package be.technofutur.haveyourstyle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technofutur.haveyourstyle.models.entities.Adress;

public interface AdressRepository extends JpaRepository<Adress,Long> {
    
}

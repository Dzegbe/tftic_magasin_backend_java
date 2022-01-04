package be.technofutur.haveyourstyle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technofutur.haveyourstyle.models.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    
}

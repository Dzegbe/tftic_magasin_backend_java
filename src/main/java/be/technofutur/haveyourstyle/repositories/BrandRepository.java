package be.technofutur.haveyourstyle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.technofutur.haveyourstyle.models.entities.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    
}

package be.technofutur.haveyourstyle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technofutur.haveyourstyle.models.entities.BrandCollection;

public interface BrandCollectionRepository extends JpaRepository<BrandCollection,Long> {
    
}

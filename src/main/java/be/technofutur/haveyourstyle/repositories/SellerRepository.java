package be.technofutur.haveyourstyle.repositories;

import org.springframework.stereotype.Repository;

import be.technofutur.haveyourstyle.models.entities.Seller;

@Repository
public interface SellerRepository extends UserRepository<Seller> {
    
}

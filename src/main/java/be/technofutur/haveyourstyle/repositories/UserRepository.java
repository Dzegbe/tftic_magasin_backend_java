package be.technofutur.haveyourstyle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.technofutur.haveyourstyle.models.entities.User;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T,Long>{
    
}

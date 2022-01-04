package be.technofutur.haveyourstyle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.technofutur.haveyourstyle.models.entities.CategoryStyle;

@Repository
public interface CategoryStyleRepository extends JpaRepository<CategoryStyle,Long>{
    
}

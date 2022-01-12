package be.technofutur.haveyourstyle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.technofutur.haveyourstyle.models.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    
}

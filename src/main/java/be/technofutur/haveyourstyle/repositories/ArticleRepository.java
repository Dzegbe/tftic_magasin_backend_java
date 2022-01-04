package be.technofutur.haveyourstyle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technofutur.haveyourstyle.models.entities.Article;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    
}

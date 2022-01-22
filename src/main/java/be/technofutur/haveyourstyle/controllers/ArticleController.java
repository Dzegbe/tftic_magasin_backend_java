package be.technofutur.haveyourstyle.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.technofutur.haveyourstyle.models.dtos.ArticleDto;
import be.technofutur.haveyourstyle.models.forms.ArticleForm;
import be.technofutur.haveyourstyle.services.serviceImpl.ArticleServiceImpl;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleServiceImpl articleService;

    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @GetMapping(path = "/pageArticle/{id}")
    public ResponseEntity<ArticleDto> getOne(@PathVariable (name = "id") Long id){
        return ResponseEntity.ok(articleService.getOne(id));
    }

    @GetMapping()
    public ResponseEntity<List<ArticleDto>> getAllArticle(){
        return ResponseEntity.ok(this.articleService.getAll());

    }

    @PostMapping()
    public ResponseEntity<ArticleDto> insertarticle(@Valid @RequestBody ArticleForm form){
        return ResponseEntity.ok(this.articleService.insert(form));
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<ArticleDto> updateOne(@PathVariable (name = "id") Long id, @Valid @RequestBody ArticleForm form){
        return ResponseEntity.ok(articleService.update(id, form));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable (name = "id") Long id){
        return ResponseEntity.ok(articleService.delete(id));
    }
}

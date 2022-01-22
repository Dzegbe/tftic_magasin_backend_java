package be.technofutur.haveyourstyle.controllers;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.technofutur.haveyourstyle.models.dtos.ArticleDto;
import be.technofutur.haveyourstyle.services.serviceImpl.SellerServiceImpl;

@RestController
@RequestMapping("/seller")
public class SellerController {

    private final SellerServiceImpl sellerService;

    public SellerController(SellerServiceImpl sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping(path = "/allArticle/{id}")
    public ResponseEntity<List<ArticleDto>> getAllArticle(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(this.sellerService.getArticle(id));
    }



    
}

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
import be.technofutur.haveyourstyle.models.dtos.BrandDto;
import be.technofutur.haveyourstyle.models.forms.BrandForm;
import be.technofutur.haveyourstyle.services.serviceImpl.ArticleServiceImpl;
import be.technofutur.haveyourstyle.services.serviceImpl.BrandServiceImpl;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandServiceImpl service;
    private final ArticleServiceImpl aService;

   
    public BrandController(BrandServiceImpl service, ArticleServiceImpl aService) {
        this.service = service;
        this.aService = aService;
    }

    @GetMapping()
    public ResponseEntity<List<BrandDto>> getAllBrand(){
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping(path= "/brandSeller/{id}")
    public ResponseEntity<List<BrandDto>> getBrandPerSeller(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(this.service.getPerSeller(id));
    }

    @GetMapping(path = "/oneBrand/{id}")
    public ResponseEntity<BrandDto> getOneBrand(@PathVariable(name = "id")Long id){
        return ResponseEntity.ok(this.service.getOne(id));
    }

    @GetMapping(path = "/allArticles/{id}")
    public ResponseEntity<List<ArticleDto>> getAllArticles(@PathVariable(name = "id")Long id){
        return ResponseEntity.ok(this.aService.getAllPerBrands(id));
    }

    @PostMapping()
    public ResponseEntity<BrandDto> insertBrand(@Valid @RequestBody BrandForm form){
        return ResponseEntity.ok(this.service.insert(form));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BrandDto> updatetBrand(@PathVariable(name = "id")Long id,
    @Valid @RequestBody BrandForm form ){
        return ResponseEntity.ok(this.service.update(id, form));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable(name = "id")Long id){
        return ResponseEntity.ok(this.service.delete(id));
    }

    
}

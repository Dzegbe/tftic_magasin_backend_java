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

import be.technofutur.haveyourstyle.models.dtos.AdressDto;
import be.technofutur.haveyourstyle.models.forms.AdressForm;
import be.technofutur.haveyourstyle.services.serviceImpl.AdressServiceImpl;

@RestController
@RequestMapping("/adress")
public class AdressControler {

    private final AdressServiceImpl adressService;

    public AdressControler(AdressServiceImpl adressService) {
        this.adressService = adressService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdressDto>> getAll(){
        return ResponseEntity.ok(adressService.getAll());
    }

    @GetMapping("/allPerCountry/{countryName}")
    public ResponseEntity<List<AdressDto>> getAllPerCountryName(@PathVariable(name = "countryName") String countryName){
        return ResponseEntity.ok(adressService.getAllPerCountry(countryName));
    }

    @GetMapping("/allPerCity/{cityName}")
    public ResponseEntity<List<AdressDto>> getAllPerCityName(@PathVariable(name = "cityName") String cityName){
        return ResponseEntity.ok(adressService.getAllPerCity(cityName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdressDto> getOneById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(adressService.getOne(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AdressDto> update(@PathVariable(name = "id") Long id,@Valid @RequestBody AdressForm form){
        return ResponseEntity.ok(adressService.update(id, form));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(adressService.delete(id));
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<AdressDto> insert(@Valid @RequestBody AdressForm form){
        return ResponseEntity.ok(adressService.insert(form));
    }

    
}

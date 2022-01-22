package be.technofutur.haveyourstyle.services.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.mapperImpl.AdressMapperImpl;
import be.technofutur.haveyourstyle.models.dtos.AdressDto;
import be.technofutur.haveyourstyle.models.entities.Adress;
import be.technofutur.haveyourstyle.models.forms.AdressForm;
import be.technofutur.haveyourstyle.repositories.AdressRepository;
import be.technofutur.haveyourstyle.services.baseServices.AdressService;

@Service
public class AdressServiceImpl implements AdressService {

    private final AdressMapperImpl adressMapper;
    private final AdressRepository adressRepository;

    

    public AdressServiceImpl(AdressMapperImpl adressMapper, AdressRepository adressRepository) {
        this.adressMapper = adressMapper;
        this.adressRepository = adressRepository;
    }

    @Override
    public List<AdressDto> getAll() {
        return adressRepository.findAll().stream().map(adressMapper::entityToDto).collect((Collectors.toList()));
    }

    @Override
    public List<AdressDto> getAllPerCountry(String countryName) {
        return adressRepository.findAll().stream().filter((adress) -> adress.getCountry().equals(countryName))
                                .map(adressMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<AdressDto> getAllPerCity(String cityName) {
        return adressRepository.findAll().stream().filter((adress) -> adress.getCity().equals(cityName))
        .map(adressMapper::entityToDto).collect(Collectors.toList());
    }


    @Override
    public AdressDto update(Long id, AdressForm form) {
        Adress a = adressRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("this Adress doesn't exist"));
        a = adressMapper.formToEntity(form,a);
       return adressMapper.entityToDto(adressRepository.save(a));
    }

    @Override
    public String delete(Long id) {
        Adress a = adressRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("this Adress doesn't exist"));
        adressRepository.delete(a);
        return adressRepository.existsById(id) ? "problem adress not delete" : "Adress deleted";
    }

    @Override
    public AdressDto getOne(Long id) {
      return adressMapper.entityToDto(adressRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("this Adress doesn't exist")));  
    }
    
    public AdressDto insert(AdressForm form){
        Adress a = new Adress();
        a = adressMapper.formToEntity(form,a);
        return adressMapper.entityToDto(adressRepository.save(a));
    }
}

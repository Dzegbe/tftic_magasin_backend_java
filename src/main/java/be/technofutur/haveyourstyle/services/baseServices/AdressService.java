package be.technofutur.haveyourstyle.services.baseServices;

import java.util.List;

import be.technofutur.haveyourstyle.models.dtos.AdressDto;
import be.technofutur.haveyourstyle.models.forms.AdressForm;

public interface AdressService {
    public List<AdressDto> getAll();
    public List<AdressDto> getAllPerCountry(String countryName);
    public List<AdressDto> getAllPerCity(String city);
    public AdressDto getOne(Long id);
    public AdressDto update(Long id, AdressForm form);
    public String delete(Long id);
}

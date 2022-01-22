package be.technofutur.haveyourstyle.mappers.mapperImpl;

import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.baseMapper.BaseMapper;
import be.technofutur.haveyourstyle.models.dtos.AdressDto;
import be.technofutur.haveyourstyle.models.entities.Adress;
import be.technofutur.haveyourstyle.models.forms.AdressForm;
@Service
public class AdressMapperImpl implements BaseMapper<AdressDto,AdressForm,Adress> {

    @Override
    public AdressDto entityToDto(Adress entity) {
        if(entity != null){
            return AdressDto.builder()
                            .id(entity.getAdressId())
                            .city(entity.getCity())
                            .country(entity.getCountry())
                            .houseNumber(entity.getHouseNumber())
                            .street(entity.getStreet())
                            .zipCode(entity.getZipCode())
                            .function(entity.getFunction())
                            .build();
        }
        return null;
    }

    @Override
    public Adress formToEntity(AdressForm form, Adress a) {
        if(form != null){
            a.setCity(form.getCity().toLowerCase());
            a.setCountry(form.getCountry().toLowerCase());
            a.setHouseNumber(form.getHouseNumber());
            a.setStreet(form.getStreet().toLowerCase());
            a.setZipCode(form.getZipCode());
            return a;
        }
        return null;
    }

    @Override
    public Adress dtoToEntity(AdressDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}

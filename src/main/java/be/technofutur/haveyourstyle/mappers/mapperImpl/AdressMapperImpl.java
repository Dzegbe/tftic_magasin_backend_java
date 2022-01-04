package be.technofutur.haveyourstyle.mappers.mapperImpl;

import be.technofutur.haveyourstyle.mappers.BaseMapper;
import be.technofutur.haveyourstyle.models.dtos.AdressDto;
import be.technofutur.haveyourstyle.models.entities.Adress;
import be.technofutur.haveyourstyle.models.forms.AdressForm;

public class AdressMapperImpl implements BaseMapper<AdressDto,AdressForm,Adress> {

    @Override
    public AdressDto entityToDto(Adress entity) {
        if(entity != null){
            return AdressDto.builder()
                            .adressId(entity.getAdressId())
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
    public Adress formToEntity(AdressForm form) {
        if(form != null){
            Adress a  = new Adress();
            a.setCity(form.getCity());
            a.setCountry(form.getCountry());
            a.setHouseNumber(form.getHouseNumber());
            a.setStreet(form.getStreet());
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

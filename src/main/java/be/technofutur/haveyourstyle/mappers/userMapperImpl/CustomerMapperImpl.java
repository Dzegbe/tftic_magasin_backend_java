package be.technofutur.haveyourstyle.mappers.userMapperImpl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.baseMapper.BaseCustomerMapper;
import be.technofutur.haveyourstyle.mappers.mapperImpl.AdressMapperImpl;
import be.technofutur.haveyourstyle.mappers.mapperImpl.ArticleMapperImpl;
import be.technofutur.haveyourstyle.mappers.mapperImpl.CustomerMeasurementsMapperImpl;
import be.technofutur.haveyourstyle.models.dtos.CustomerDto;
import be.technofutur.haveyourstyle.models.entities.Customer;
import be.technofutur.haveyourstyle.models.forms.userforms.CustomerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.UserFormLogin;

@Service
public class CustomerMapperImpl implements BaseCustomerMapper<CustomerDto,CustomerRegisterForm,UserFormLogin,Customer> {

    private final CustomerMeasurementsMapperImpl cmMapper;
    private final ArticleMapperImpl articleMapper;
    private final AdressMapperImpl adressMapper;

    


    public CustomerMapperImpl(CustomerMeasurementsMapperImpl cmMapper, ArticleMapperImpl articleMapper,
            AdressMapperImpl adressMapper) {
        this.cmMapper = cmMapper;
        this.articleMapper = articleMapper;
        this.adressMapper = adressMapper;
    }

    @Override
    public CustomerDto entityToDto(Customer entity) {
        if(entity != null){
            return CustomerDto.builder()
                              .id(entity.getUserId())
                              .email(entity.getEmail())
                              .gsmNumber(entity.getGsmNumber())
                              .measurements(cmMapper.entityToDto(entity.getMeasurement()))
                              .name(entity.getName())
                              .roles(entity.getRoles())
                              .surname(entity.getSurname())
                              .telNumber(entity.getTelNumber())
                              .username(entity.getSurname())
                              .wishList(entity.getWishList().stream().map(articleMapper::entityToDto).collect(Collectors.toList()))
                              .accountNonExpired(entity.isAccountNonExpired())
                              .accountNonLocked(entity.isAccountNonLocked())
                              .adress(entity.getAdress().stream().map(adressMapper::entityToDto).collect(Collectors.toList()))
                              .credentialsNonExpired(entity.isCredentialsNonExpired())
                              .enabled(entity.isEnabled())
                              .build();
        }
        return null;
    }


    @Override
    public Customer dtoToEntity(CustomerDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}

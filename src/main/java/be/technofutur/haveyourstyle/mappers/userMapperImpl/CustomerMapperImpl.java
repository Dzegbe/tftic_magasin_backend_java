package be.technofutur.haveyourstyle.mappers.userMapperImpl;

import java.util.stream.Collectors;

import be.technofutur.haveyourstyle.mappers.BaseCustomerMapper;
import be.technofutur.haveyourstyle.mappers.mapperImpl.AdressMapperImpl;
import be.technofutur.haveyourstyle.mappers.mapperImpl.ArticleMapperImpl;
import be.technofutur.haveyourstyle.mappers.mapperImpl.CustomerMeasurementsMapperImpl;
import be.technofutur.haveyourstyle.models.dtos.CustomerDto;
import be.technofutur.haveyourstyle.models.entities.Customer;
import be.technofutur.haveyourstyle.models.forms.userforms.CustomerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.UserFormLogin;

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
                              .userId(entity.getUserId())
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
    public Customer register(CustomerRegisterForm formRegister) {
        if(formRegister != null){
            Customer customer = new Customer();
            customer.setEmail(formRegister.getEmail());
            customer.setGsmNumber(formRegister.getGsmNumber());
            customer.setTelNumber(formRegister.getTelNumber());
            customer.setAdress(formRegister.getAdress().stream().map(adressMapper::formToEntity).collect(Collectors.toList()));
            customer.setName((formRegister.getName()));
            customer.setSurname(formRegister.getSurname());
            customer.setUsername(formRegister.getUsername());
            customer.setPassword(formRegister.getPassword());
            return customer;

        }
        return null;
    }

    @Override
    public Customer dtoToEntity(CustomerDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}

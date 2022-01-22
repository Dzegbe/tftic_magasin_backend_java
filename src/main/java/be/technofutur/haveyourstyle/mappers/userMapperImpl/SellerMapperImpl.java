package be.technofutur.haveyourstyle.mappers.userMapperImpl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.baseMapper.BaseSellerMapper;
import be.technofutur.haveyourstyle.mappers.mapperImpl.AdressMapperImpl;
import be.technofutur.haveyourstyle.models.dtos.IndividualSellerDto;
import be.technofutur.haveyourstyle.models.dtos.ProfessionalSellerDto;
import be.technofutur.haveyourstyle.models.entities.Seller;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SellerMapperImpl implements BaseSellerMapper {
    private final AdressMapperImpl adressMapper;


    public SellerMapperImpl(AdressMapperImpl adressMapper) {
        this.adressMapper = adressMapper;
    }

    @Override
    public IndividualSellerDto entityToDtoIndividual(Seller seller) {
       if( seller != null){
           return IndividualSellerDto.builder()
                                     .id(seller.getUserId())
                                     .username(seller.getUsername())
                                     .adress(seller.getAdress().stream().map(adressMapper::entityToDto).collect(Collectors.toList()))
                                     .gsmNumber(seller.getGsmNumber())
                                     .telNumber(seller.getTelNumber())
                                     .roles(seller.getRoles())
                                     .email(seller.getEmail())
                                     .name(seller.getName())
                                     .surname(seller.getSurname())
                                     .accountNonExpired(seller.isAccountNonExpired())
                                     .accountNonLocked(seller.isAccountNonLocked())
                                     .credentialsNonExpired(seller.isCredentialsNonExpired())
                                     .enabled(seller.isEnabled())
                                     .build();              
           
       }
        return null;
    }

    @Override
    public ProfessionalSellerDto entityToDtoProfessional(Seller seller) {
        if( seller != null){
          return ProfessionalSellerDto.builder()
                                      .id(seller.getUserId())
                                      .username(seller.getUsername())
                                      .adress(seller.getAdress().stream().map(adressMapper::entityToDto).collect(Collectors.toList()))
                                      .gsmNumber(seller.getGsmNumber())
                                      .telNumber(seller.getTelNumber())
                                      .roles(seller.getRoles())
                                      .email(seller.getEmail())
                                      .TvaNumber(seller.getTvaNumber())
                                      .companyNumber(seller.getCompanyNumber())
                                      .companyName(seller.getCompanyName())
                                      .fax(seller.getFax())
                                      .accountNonExpired(seller.isAccountNonExpired())
                                      .accountNonLocked(seller.isAccountNonLocked())
                                      .credentialsNonExpired(seller.isCredentialsNonExpired())
                                      .enabled(seller.isEnabled())
                                      .build();
           
           
                
        }
        return null;
    }

    


    
}

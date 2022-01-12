package be.technofutur.haveyourstyle.mappers.userMapperImpl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.baseMapper.BaseSellerMapper;
import be.technofutur.haveyourstyle.mappers.mapperImpl.AdressMapperImpl;
import be.technofutur.haveyourstyle.mappers.mapperImpl.ArticleMapperImpl;
import be.technofutur.haveyourstyle.mappers.mapperImpl.BrandMapperImpl;
import be.technofutur.haveyourstyle.models.dtos.IndividualSellerDto;
import be.technofutur.haveyourstyle.models.dtos.ProfessionalSellerDto;
import be.technofutur.haveyourstyle.models.entities.Seller;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SellerMapperImpl implements BaseSellerMapper {
    private final AdressMapperImpl adressMapper;
    private final ArticleMapperImpl articleMapper;
    private final BrandMapperImpl brandMapper;



    public SellerMapperImpl(AdressMapperImpl adressMapper, ArticleMapperImpl articleMapper,
            BrandMapperImpl brandMapper) {
        this.adressMapper = adressMapper;
        this.articleMapper = articleMapper;
        this.brandMapper = brandMapper;
    }

    @Override
    public IndividualSellerDto entityToDtoIndividual(Seller seller) {
       if( seller != null){
           IndividualSellerDto dto = IndividualSellerDto.builder()
                                     .userId(seller.getUserId())
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
            if(seller.getBrands() != null){
                dto.setBrands(seller.getBrands().stream().map(brandMapper::entityToDto).collect(Collectors.toList()));
            }
            if(seller.getArticles() != null){
                dto.setArticles(seller.getArticles().stream().map(articleMapper::entityToDto).collect(Collectors.toList()));
            }
            return dto;
       }
        return null;
    }

    @Override
    public ProfessionalSellerDto entityToDtoProfessional(Seller seller) {
        if( seller != null){
           ProfessionalSellerDto dto = ProfessionalSellerDto.builder()
                                      .userId(seller.getUserId())
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
            if(seller.getBrands() != null){
                dto.setBrands(seller.getBrands().stream().map(brandMapper::entityToDto).collect(Collectors.toList()));
            }
            if(seller.getArticles() != null){
                dto.setArticles(seller.getArticles().stream().map(articleMapper::entityToDto).collect(Collectors.toList()));
            }
            return dto;
                
        }
        return null;
    }

    


    
}

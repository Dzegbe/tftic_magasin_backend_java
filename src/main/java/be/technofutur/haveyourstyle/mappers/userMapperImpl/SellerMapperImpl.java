package be.technofutur.haveyourstyle.mappers.userMapperImpl;

import java.util.stream.Collectors;

import be.technofutur.haveyourstyle.mappers.BaseSellerMapper;
import be.technofutur.haveyourstyle.mappers.mapperImpl.AdressMapperImpl;
import be.technofutur.haveyourstyle.mappers.mapperImpl.ArticleMapperImpl;
import be.technofutur.haveyourstyle.mappers.mapperImpl.BrandMapperImpl;
import be.technofutur.haveyourstyle.models.dtos.IndividualSellerDto;
import be.technofutur.haveyourstyle.models.dtos.ProfessionalSellerDto;
import be.technofutur.haveyourstyle.models.entities.Seller;
import be.technofutur.haveyourstyle.models.forms.userforms.IndividualSellerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.ProSellerRegisterForm;

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
           return IndividualSellerDto.builder()
                                     .userId(seller.getUserId())
                                     .username(seller.getUsername())
                                     .adress(seller.getAdress().stream().map(adressMapper::entityToDto).collect(Collectors.toList()))
                                     .gsmNumber(seller.getGsmNumber())
                                     .telNumber(seller.getTelNumber())
                                     .roles(seller.getRoles())
                                     .brands(seller.getBrands().stream().map(brandMapper::entityToDto).collect(Collectors.toList()))
                                     .email(seller.getEmail())
                                     .articles(seller.getArticles().stream().map(articleMapper::entityToDto).collect(Collectors.toList()))
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
                                      .userId(seller.getUserId())
                                      .username(seller.getUsername())
                                      .adress(seller.getAdress().stream().map(adressMapper::entityToDto).collect(Collectors.toList()))
                                      .gsmNumber(seller.getGsmNumber())
                                      .telNumber(seller.getTelNumber())
                                      .roles(seller.getRoles())
                                      .brands(seller.getBrands().stream().map(brandMapper::entityToDto).collect(Collectors.toList()))
                                      .email(seller.getEmail())
                                      .articles(seller.getArticles().stream().map(articleMapper::entityToDto).collect(Collectors.toList()))
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

    @Override
    public Seller formToEntityIndividual(IndividualSellerRegisterForm formIndividual) {
       if(formIndividual != null){
           Seller seller = new Seller();
           seller.setUsername(formIndividual.getUsername());
           seller.setAdress(formIndividual.getAdress().stream().map(adressMapper::formToEntity).collect(Collectors.toList()));
           seller.setGsmNumber(formIndividual.getGsmNumber());
           seller.setTelNumber(formIndividual.getTelNumber());
           seller.setEmail(formIndividual.getEmail());
           seller.setPassword(formIndividual.getPassword());
           seller.setName(formIndividual.getName());
           seller.setSurname(formIndividual.getSurname());
           return seller;
       }
        return null;
    }

    @Override
    public Seller formToEntityPrfessional(ProSellerRegisterForm formProfessional) {
        if(formProfessional != null){
            Seller seller = new Seller();
            seller.setUsername(formProfessional.getUsername());
            seller.setAdress(formProfessional.getAdress().stream().map(adressMapper::formToEntity).collect(Collectors.toList()));
            seller.setGsmNumber(formProfessional.getGsmNumber());
            seller.setTelNumber(formProfessional.getTelNumber());
            seller.setEmail(formProfessional.getEmail());
            seller.setPassword(formProfessional.getPassword());
            seller.setTvaNumber(formProfessional.getTvaNumber());
            seller.setCompanyNumber(formProfessional.getCompanyNumber());
            seller.setCompanyName(formProfessional.getCompanyName());
            seller.setFax((formProfessional.getFax()));
            return seller;
        }
        return null;
    }
    


    
}

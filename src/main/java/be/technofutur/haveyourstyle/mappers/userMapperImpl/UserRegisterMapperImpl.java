package be.technofutur.haveyourstyle.mappers.userMapperImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import be.technofutur.haveyourstyle.mappers.baseMapper.RegisterMapperUsers;
import be.technofutur.haveyourstyle.mappers.mapperImpl.AdressMapperImpl;
import be.technofutur.haveyourstyle.models.entities.Adress;
import be.technofutur.haveyourstyle.models.entities.Customer;
import be.technofutur.haveyourstyle.models.entities.Seller;
import be.technofutur.haveyourstyle.models.forms.userforms.CustomerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.IndividualSellerRegisterForm;
import be.technofutur.haveyourstyle.models.forms.userforms.ProSellerRegisterForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserRegisterMapperImpl implements RegisterMapperUsers {

    private final AdressMapperImpl adressMapper;


    public UserRegisterMapperImpl(AdressMapperImpl adressMapper) {
        this.adressMapper = adressMapper;
    }

    @Override
    public Customer register(CustomerRegisterForm formRegister, Customer customer) {
        if(formRegister != null){
            customer.setEmail(formRegister.getEmail());
            customer.setGsmNumber(formRegister.getGsmNumber());
            customer.setTelNumber(formRegister.getTelNumber());
            Adress a = new Adress();
            a = adressMapper.formToEntity(formRegister.getAdress(),a);
            a.setFunction(List.of("DOMICIL"));
            if(customer.getAdress()!= null)
               customer.getAdress().add(a);
            else
                customer.setAdress(List.of(a));
            customer.setName((formRegister.getName()).toLowerCase());
            customer.setSurname(formRegister.getSurname().toLowerCase());
            customer.setPassword(formRegister.getPassword());
            return customer;

        }
        return null;
    }

    @Override
    public Seller formToEntityIndividual(IndividualSellerRegisterForm formIndividual,Seller seller) {
       if(formIndividual != null){
           log.info("!!!!! je passe");
           Adress a = new Adress();
           a = adressMapper.formToEntity(formIndividual.getAdress(),a);
           a.setFunction(List.of("DOMICIL"));
           if(seller.getAdress()!= null)
            seller.getAdress().add(a);
           else
            seller.setAdress(List.of(a));
           seller.setGsmNumber(formIndividual.getGsmNumber());
           seller.setTelNumber(formIndividual.getTelNumber());
           seller.setEmail(formIndividual.getEmail());
           seller.setPassword(formIndividual.getPassword());
           seller.setName(formIndividual.getName().toLowerCase());
           seller.setSurname(formIndividual.getSurname().toLowerCase());
           seller.setCompanyName(null);
           seller.setFax(null);
           seller.setTvaNumber(null);
           seller.setCompanyNumber(null);
           if(formIndividual.getSocialNetwork() != null){
                seller.setSocialNetwork(formIndividual.getSocialNetwork());
            }
           return seller;
       }
        return null;
    }

    @Override
    public Seller formToEntityPrfessional(ProSellerRegisterForm formProfessional, Seller seller) {
        if(formProfessional != null){
          Adress a = new Adress();
            a = adressMapper.formToEntity(formProfessional.getAdress(),a);
            a.setFunction(List.of("DOMICIL"));
            if(seller.getAdress()!= null)
                seller.getAdress().add(a);
            else
                seller.setAdress(List.of(a));
            seller.setGsmNumber(formProfessional.getGsmNumber());
            seller.setTelNumber(formProfessional.getTelNumber());
            seller.setEmail(formProfessional.getEmail());
            seller.setPassword(formProfessional.getPassword());
            seller.setTvaNumber(formProfessional.getTvaNumber());
            seller.setCompanyNumber(formProfessional.getCompanyNumber());
            seller.setCompanyName(formProfessional.getCompanyName().toLowerCase());
            seller.setFax((formProfessional.getFax()));
            if(formProfessional.getSocialNetwork() != null){
                seller.setSocialNetwork(formProfessional.getSocialNetwork());
            }
            return seller;
        }
        return null;
    }


}
